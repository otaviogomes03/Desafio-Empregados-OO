package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Dia do pagamento: ");
		int payDay =  sc.nextInt();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.nextLine();
		System.out.print("Telefone: ");
		String phone = sc.nextLine();
		
		Address address = new Address(email, phone);
		
		System.out.print("Quantos funcionários tem o departamento? ");
		int N = sc.nextInt();
		
		Department department = new Department(departmentName, payDay, address);
		
		for (int i = 1; i <= N; i++) {
			System.out.println("Dados do funcionário " + i + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salário: ");
			double salary = sc.nextDouble();	
			
			Employee emp = new Employee(name, salary);
			
			department.addEmployee(emp);
		}
		
		System.out.println();
		
		showReport(department);
		
		sc.close();
	}
	
	public static void showReport(Department department) {
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.printf("Departamento %s = R$ %.2f\n", department.getName(), department.payroll());
		System.out.println("Pagamento realizado no dia " + department.getPayDay());
		System.out.println("Funcionários: ");
		for (Employee emp : department.getEmployees()) {
			System.out.println(emp.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + department.getAdress().getEmail());
	}

}
