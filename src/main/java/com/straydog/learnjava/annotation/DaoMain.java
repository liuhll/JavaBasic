package com.straydog.learnjava.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jyyc on 2017/5/4.
 */
public class DaoMain {

    public static void main(String[] args) {

        TeacherFilter teacherFilter = new TeacherFilter();

        //teacherFilter.setAge(10);
        teacherFilter.setName("张三");
        String sql = query(teacherFilter);
        System.out.println(sql);

        TeacherFilter filter2 = new TeacherFilter();

        filter2.setAge(30);
        filter2.setTeachCourse("数学,语文,体育");
        String sql2 = query(filter2);
        System.out.println(sql2);


    }

    private static <E> String query(E filter){

        StringBuilder sb = new StringBuilder();
        Class<?> clazz = filter.getClass();
        boolean isExitTableAnn = clazz.isAnnotationPresent(Table.class);
        if (!isExitTableAnn){
            return null;
        }
        Table tableInfo = clazz.getAnnotation(Table.class);
        String tableName = tableInfo.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field: fields){
            // 拿到列名和对应列的值
            boolean isExitColAnn = field.isAnnotationPresent(Column.class);
            if(!isExitColAnn){
                continue;
            }
            Column columnInfo = field.getAnnotation(Column.class);
            String columnName = columnInfo.value();

            String columnPropMethodName = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
            try {
                Method colunmPropMethod = clazz.getMethod(columnPropMethodName);
                Object colunmValue = colunmPropMethod.invoke(filter,null);

                if (colunmValue == null || (colunmValue instanceof Integer && (Integer)colunmValue ==0)){
                    continue;
                }
                sb.append(" and ").append(columnName);

                if (colunmValue instanceof String){
                    if (((String) colunmValue).contains(",")){
                        String[] colValues = ((String) colunmValue).split(",");
                        sb.append(" in(");
                        for (String colv: colValues){
                            sb.append("'").append(colv).append("'").append(",");
                        }
                        sb.deleteCharAt(sb.length() -1);
                        sb.append(")");

                    }else {
                        sb.append("=").append("'").append(colunmValue).append("'");
                    }
                }
                if (colunmValue instanceof Integer){
                    sb.append("=").append(colunmValue);
                }


            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}


