package was.httpserver.servlet.reflection;

import was.httpserver.HttpRequest;
import was.httpserver.HttpResponse;
import was.httpserver.HttpServlet;
import was.httpserver.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectionServlet implements HttpServlet {

    private final List<Object> controllers;

    public ReflectionServlet(List<Object> controllers) {
        this.controllers = controllers;
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();

        //SiteController, SearchController
        for (Object controller : controllers) {
            Class<?> clazz = controller.getClass();
            Method[] methods = clazz.getMethods();
            //methods[0]: site1, site2, methods[1]: search
            for (Method method : methods) {
                String methodName = method.getName();
                if (path.equals("/" + methodName)) { // /site1.equals(/site1)
                    invoke(controller, method, request, response);
                    return;
                }
            }
        }
        throw new PageNotFoundException("request = " + path);
    }

    // ctrl+alt+shift+T -> change signature
    private static void invoke(Object controller, Method method, HttpRequest request, HttpResponse response) {
        try {
            method.invoke(controller, request, response);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
