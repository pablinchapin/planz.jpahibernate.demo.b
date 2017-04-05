package com.pablinchapin.jpahibernate.demo.b.test;

import com.pablinchapin.jpahibernate.demo.b.model.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by pvargas on 5/04/17.
 */
public class TestEmpleados {

    private static EntityManagerFactory emf;
    private static EntityManager manager;

    @SuppressWarnings("unchecked")
    public static void main(String[] args){

        emf = Persistence.createEntityManagerFactory("aplicacion");
        manager = emf.createEntityManager();

        Empleado e1 = new Empleado(10L, "Vargas", "Pablo", new GregorianCalendar(1980,6,3).getTime());

        Empleado e2 = new Empleado(20L, "Vargas", "Pablo Andres", new GregorianCalendar(2000,11,7).getTime());

        manager.getTransaction().begin();
        manager.persist(e1);
        manager.persist(e2);
        manager.getTransaction().commit();

        //List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        //System.out.println("En esta base de datos hay "+empleados.size()+ " empleados");

        imprimirTodo();
    }

    @SuppressWarnings("unchecked")
    public static void imprimirTodo() {
        List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
        System.out.println("En esta base de datos hay " + empleados.size() + " empleados");

        for (Empleado empleado : empleados ){
            System.out.println(empleado.toString());
        }
    }

}
