package sanandreasp.core.manpack.helpers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import com.google.common.collect.Maps;

import cpw.mods.fml.relauncher.ReflectionHelper.UnableToAccessFieldException;
import cpw.mods.fml.relauncher.ReflectionHelper.UnableToFindMethodException;

public final class CachedReflectionHelper
{
    private static Map<String, Method> cachedMethods = Maps.newHashMap();
    private static Map<String, Field> cachedFields = Maps.newHashMap();

    public static <T, E> void setCachedFieldValue(Class<? super E> classToAccess, E instance, String mcpName, String srgName, T value) {
        Field field = getCachedField(classToAccess, mcpName, srgName);
        try {
            field.set(instance, value);
        } catch( Throwable ex ) {
            throw new UnableToSetFieldException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T, E> T getCachedFieldValue(Class<? super E> classToAccess, E instance, String mcpName, String srgName) {
        Field field = getCachedField(classToAccess, mcpName, srgName);
        try {
            return (T) field.get(instance);
        } catch( IllegalArgumentException | IllegalAccessException ex ) {
            throw new UnableToGetFieldException(ex);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T, E> T invokeCachedMethod(Class<? super E> classToAccess, E instance, String mcpName,
                                              String srgName, Class<?>[] parameterTypes, Object[] parameterValues) {
        Method method = getCachedMethod(classToAccess, mcpName, srgName, parameterTypes);
        try {
            return (T) method.invoke(instance, parameterValues);
        } catch( IllegalAccessException | IllegalArgumentException | InvocationTargetException ex ) {
            throw new UnableToInvokeMethodException(ex);
        }
    }

    public static Field getCachedField(Class<?> classToAccess, String mcpName, String srgName) {
        String key = classToAccess.getCanonicalName() + "_" + srgName;
        if( cachedFields.containsKey(key) ) {
            return cachedFields.get(key);
        }
        return cacheAccessedField(classToAccess, mcpName, srgName);
    }

    private static Field cacheAccessedField(Class<?> classToAccess, String mcpName, String srgName) {
        Field method;
        String key = classToAccess.getCanonicalName() + "_" + srgName;
        try {
            method = classToAccess.getDeclaredField(srgName);
            method.setAccessible(true);
            cachedFields.put(key, method);
            return method;
        } catch( Exception ex1 ) {
            try {
                method = classToAccess.getDeclaredField(mcpName);
                method.setAccessible(true);
                cachedFields.put(key, method);
                return method;
            } catch( Exception ex2 ) {
                throw new UnableToAccessFieldException(new String[] { mcpName, srgName }, ex2);
            }
        }
    }

    public static Method getCachedMethod(Class<?> classToAccess, String mcpName, String srgName, Class<?>... parameterTypes) {
        String key = classToAccess.getCanonicalName() + "_" + srgName;
        if( cachedMethods.containsKey(key) ) {
            return cachedMethods.get(key);
        }
        return cacheAccessedMethod(classToAccess, mcpName, srgName, parameterTypes);
    }

    private static Method cacheAccessedMethod(Class<?> classToAccess, String mcpName, String srgName, Class<?>... parameterTypes) {
        Method method;
        String key = classToAccess.getCanonicalName() + "_" + srgName;
        try {
            method = classToAccess.getDeclaredMethod(srgName, parameterTypes);
            method.setAccessible(true);
            cachedMethods.put(key, method);
            return method;
        } catch( Exception ex1 ) {
            try {
                method = classToAccess.getDeclaredMethod(mcpName, parameterTypes);
                method.setAccessible(true);
                cachedMethods.put(key, method);
                return method;
            } catch( Exception ex2 ) {
                throw new UnableToFindMethodException(new String[] { mcpName, srgName }, ex2);
            }
        }
    }

    public static class UnableToSetFieldException
        extends RuntimeException
    {
        private static final long serialVersionUID = 1L;

        public UnableToSetFieldException(Throwable ex) {
            super(ex);
        }
    }

    public static class UnableToGetFieldException
        extends RuntimeException
    {
        private static final long serialVersionUID = 1L;

        public UnableToGetFieldException(Throwable failed) {
            super(failed);
        }
    }

    public static class UnableToInvokeMethodException
        extends RuntimeException
    {
        private static final long serialVersionUID = 1L;

        public UnableToInvokeMethodException(Throwable failed) {
            super(failed);
        }
    }
}