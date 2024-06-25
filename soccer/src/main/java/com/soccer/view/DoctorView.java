package com.soccer.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.soccer.model.entity.Doctor;

public class DoctorView {

    private static List<Doctor> doctors = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Doctor Management System =====");
            System.out.println("1. Create Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    createDoctor(scanner);
                    break;
                case 2:
                    viewAllDoctors();
                    break;
                case 3:
                    updateDoctor(scanner);
                    break;
                case 4:
                    deleteDoctor(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
    }

    private static void createDoctor(Scanner scanner) {
        System.out.println("\n===== Create Doctor =====");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Años de experiencia: ");
        int expYear = scanner.nextInt();
        scanner.nextLine(); 

        Doctor newDoctor = new Doctor(nextId, nombre, apellido, edad, titulo, expYear);
        doctors.add(newDoctor);
        nextId++;

        System.out.println("Doctor created successfully:\n" + newDoctor);
    }

    private static void viewAllDoctors() {
        System.out.println("\n===== All Doctors =====");
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    private static void updateDoctor(Scanner scanner) {
        System.out.println("\n===== Update Doctor =====");
        System.out.print("Enter Doctor ID to update: ");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine(); 
        boolean found = false;
        for (Doctor doctor : doctors) {
            if (doctor.getId() == idToUpdate) {
                System.out.println("Current details:\n" + doctor);
                System.out.print("New Nombre (press Enter to keep current value '" + doctor.getNombre() + "'): ");
                String newNombre = scanner.nextLine();
                if (!newNombre.isEmpty()) {
                    doctor.setNombre(newNombre);
                }

                System.out.print("New Apellido (press Enter to keep current value '" + doctor.getApellido() + "'): ");
                String newApellido = scanner.nextLine();
                if (!newApellido.isEmpty()) {
                    doctor.setApellido(newApellido);
                }

                System.out.print("New Edad (press Enter to keep current value '" + doctor.getEdad() + "'): ");
                String newEdadStr = scanner.nextLine();
                if (!newEdadStr.isEmpty()) {
                    int newEdad = Integer.parseInt(newEdadStr);
                    doctor.setEdad(newEdad);
                }

                System.out.print("New Titulo (press Enter to keep current value '" + doctor.getTitulo() + "'): ");
                String newTitulo = scanner.nextLine();
                if (!newTitulo.isEmpty()) {
                    doctor.setTitulo(newTitulo);
                }

                System.out.print("New Años de experiencia (press Enter to keep current value '" + doctor.getExpYear() + "'): ");
                String newExpYearStr = scanner.nextLine();
                if (!newExpYearStr.isEmpty()) {
                    int newExpYear = Integer.parseInt(newExpYearStr);
                    doctor.setExpYear(newExpYear);
                }

                System.out.println("Doctor with ID " + idToUpdate + " updated successfully:\n" + doctor);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Doctor with ID " + idToUpdate + " not found.");
        }
    }

    private static void deleteDoctor(Scanner scanner) {
        System.out.println("\n===== Delete Doctor =====");
        System.out.print("Enter Doctor ID to delete: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine(); 

        boolean found = false;
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == idToDelete) {
                Doctor deletedDoctor = doctors.remove(i);
                System.out.println("Doctor with ID " + idToDelete + " deleted successfully:\n" + deletedDoctor);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Doctor with ID " + idToDelete + " not found.");
        }
    }
}
