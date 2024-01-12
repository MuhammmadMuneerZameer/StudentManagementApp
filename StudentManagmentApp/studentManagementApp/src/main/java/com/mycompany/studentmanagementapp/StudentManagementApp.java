/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmanagementapp;


import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author zmune
 */
public class StudentManagementApp extends StudentsDataBase {
     
     String Task;
     
  
   
    public String getTask(){
        return Task;
    }
     static void Department(String DepartmentName) throws IOException{
    String DepartmentFileLocation="C:\\Users\\zmune\\OneDrive\\Desktop\\java\\";
        File F =new File(DepartmentFileLocation+"Department.text");
        try (BufferedReader reader = new BufferedReader(new FileReader(F))){
            String line;
            List<String> Depart=new ArrayList<>();
            
            while ((line = reader.readLine()) != null){
               Depart.add(line);
               }
                
        
            System.out.println("this is the data from the depart folder");
           for(int i=0;i<Depart.size();i++){
                String[] DepartDetails=Depart.get(i).split(",");
                System.out.println(DepartDetails[0]);
           }
        }
    }
    static String[] RollNoCheck(String n) throws IOException{
         String Location="C:\\Users\\zmune\\OneDrive\\Desktop\\java\\";
         File F= new File(Location,"Student.text");
    
        Scanner sc=new Scanner(System.in);
        try (BufferedReader reader = new BufferedReader(new FileReader(F))) {
        String line;
        List<String> StudentNames= new ArrayList<>();
        String[] StudentInfo = null;
        
        while ((line = reader.readLine()) != null){
//            System.out.println("-----------"+line);
            if(!line.equals(" ")){
                StudentNames.add(line);
            }   
            else{
                StudentNames.remove(line);
            }
        }
        int count=0;
        System.out.println("Enter your roll no");
           String RollNo=n;
        for(int i=0;i<StudentNames.size();i++){
            StudentInfo=StudentNames.get(i).split(",");
               

           
           if(StudentInfo[1].equals(RollNo)){
//               
              
               count++;
//               break;
               
           }
           
           
        }
        if(count==1){
            System.out.println("Student Available!!");
             return StudentInfo;

        }
        else{
               System.out.println("Student Not Available");
               return null;
           }

          
        }}
    
    static void SeeDashboard(String n) throws IOException{
        String Location="C:\\Users\\zmune\\OneDrive\\Desktop\\java\\";
        File F= new File(Location,"Student.text");
        
        
        Scanner sc=new Scanner(System.in);
        if("Admin".equals(n)){
            System.out.println("What do you want to \n 1.Manage Students \n 2.Fee Allowance");
        int task=sc.nextInt();
        if(task==1){
           System.out.println("What do you want to do \n 1.Add Student \n 2.Delete Student");
           int StudentF=sc.nextInt();
           if(StudentF==1){
//               SDB("Add");
           }
           else if(StudentF==2){
//               SDB("Delete");
           }
           
           
          
        }
        else if(task==2){
            
        }
        }
        if("Student".equals(n)){
            System.out.println("What do you want to \n 1.Check Attendance \n 2.Fee Allowance");
        int task=sc.nextInt();
        
        if(task==1){
//            RollNoCheck();
//        
//            
//        }
        }
        if(task==2){
        
            Department("SE");
        }
        
        
        
    }}
   public static void UserCheck(int User) throws IOException{
       
           System.out.println("enter username");
            Scanner sc= new Scanner(System.in);
           String admin= sc.next();
           if("admin".equals(admin)){
               System.out.println("enter password");
               String password= sc.next();
               if("12345".equals(password)){
                   System.out.println("Werlcome Admin!!");
                   SeeDashboard("a");
                   
               }
               else{
                   System.out.println("Incorrect Password");
               }
           }
          
//           System.out.println("enter username");
//            Scanner sc= new Scanner(System.in);
//           String admin= sc.next();
           if("student".equals(admin)){
               System.out.println("enter password");
               String password= sc.next();
               if("0000".equals(password)){
                   System.out.println("Werlcome Student!!");
                   SeeDashboard("s");
                   
               }
               else{
                   System.out.println("Incorrect Password");
               }
           }}
           
          
           
       
   
   
//   Main command method is called here!!
   
    public static void main(String[] args) throws IOException {      
//          int User=sc.nextInt();
//        UserCheck(User);
//          SeeDashboard("s");
//        SDB("Add");
//        Frame();
       LoginInfo log = new LoginInfo();
       log.setVisible(true);


        
        
        
    }
}
//Student Data Writing And Updating Methods Here!!
class StudentsDataBase{
    public static void WriteData(List<String> n,File FileName) throws IOException{
            FileWriter writer= new FileWriter(FileName,true);
            String StudentInfo=String.join(",",n);
            System.out.println(StudentInfo);
            writer.write("\n"+StudentInfo);
            writer.close();
    }
    public static void UpdateData(List<String> UpdatedStudentNames, File F) throws IOException{
        FileWriter writer= new FileWriter(F);
        for(int i=0;i<UpdatedStudentNames.size();i++){
            
            writer.write("\n"+UpdatedStudentNames.get(i));
           
        }
         writer.close();
         System.out.println("Done!!");
    }
    
    
    public static void GetData(){
        
    }
    public static void SDB(String n,ArrayList<String>  StudentData) throws IOException{
        Scanner sc = new Scanner(System.in);
        String Location="C:\\Users\\zmune\\OneDrive\\Desktop\\java\\";
        File F= new File(Location,"Student.text");
        if(n.equals("Add")){
//            System.out.println("Input the following details: \n Full Name \n Department Name \n Age \n BatchNo  ");
//            String Name=sc.nextLine();
//            ArrayList<String>  StudentData;
//            String[]  StudentDataArray=Name.split(",");
//            StudentData=new ArrayList<>(Arrays.asList(StudentDataArray));
            Random random=new Random();
            String studentnumber1;
        int studentnumber=random.nextInt(9000)+100;
        studentnumber1=Integer.toString(studentnumber);
            StudentData.add(1,studentnumber1);
                    
            
            System.out.println("Student Data:"+StudentData);
            WriteData(StudentData,F);
            
        }
        else if(n.equals("Delete")){
            
             try (BufferedReader reader = new BufferedReader(new FileReader(F))) {
        String line;
        List<String> StudentNames= new ArrayList<>();
        
        while ((line = reader.readLine()) != null){
            System.out.println("-----------"+line);
            if(!line.equals(" ")){
                StudentNames.add(line);
            }
        }
                System.out.println(StudentNames);
            
            
            String Name=StudentData.get(0);
            boolean StudentAvailable=false;
//            FileWriter writer= new FileWriter(F,true);
            for(int i=0;i<StudentNames.size();i++){
                String[] StudentInfo=StudentNames.get(i).split(",");
//                if(StudentNames.get(i).equals("")){
//                         boolean remove = StudentNames.remove(StudentNames.get(i));
//                    UpdateData(StudentNames, F);
//                        }
                if(!StudentInfo[0].equals(Name)){
                    
                } else {
                    StudentAvailable=true;
                    StudentNames.remove(StudentNames.get(i));
                    UpdateData(StudentNames, F);
                    System.out.println("Removed Successfully!!");
                    DeleteStudent D=new DeleteStudent();
                    D.SetTextArea("Removed Succesfully");
                    break;
            }    
            }
            
          
    } catch (IOException e) {
        e.printStackTrace();
    }
            
            
        }
    }
}

    