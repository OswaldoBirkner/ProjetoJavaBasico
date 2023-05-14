import builders.StudentsBuilder;
import entities.Student;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        var allStudents = StudentsBuilder.getAllStudents();
        Scanner option = new Scanner(System.in);
        System.out.println("""
                Please enter the number corresponding to the desired option:\s
                1 - List of students who passed the year (average equal to 7.0 or higher)
                2 - List of students who did not pass the year (average below 7.0)
                3 - List of student(s) who achieved the highest grade (in this case: 10.0)
                4 - List of students who achieved the lowest grade
                5 - Top 3 list of student grades
                6 - List of the three lowest grades of students
                7 - List of averages of all students""");
        int input = option.nextInt();

        switch (input) {
            case 1:
                studentsPass(allStudents);
                break;

            case 2:
                studentsFail(allStudents);
                break;

            case 3:
                highestGrade(allStudents);
                break;

            case 4:
                lowestGrade(allStudents);
                break;

            case 5:
                topThree(allStudents);
                break;

            case 6:
                worstThree(allStudents);
                break;

            case 7:
                allAverages(allStudents);
                break;

            default:
                System.out.println("Unexpected value: " + input + ", please enter a valid option!");




            /*
        5. Faça uma lista com top 3 notas de alunos. Em caso de notas iguais coloque todos na mesma posição.
            - Ex:
                1º - Fulano : Nota = 10.0;
                   - Beltrano : Nota = 10.0;
                2º - Joãozinho : Nota = 9.0;
                3º - Mariazinha : Nota = 8.9;
            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
        */

       /*
        6. Faça uma lista com as 3 menores notas de alunos. Em caso de notas iguais coloque todos na mesma posição. Exemplo igual a anterior
            - Exiba os dados nesse formato: <posicao> - <nome> : Nota = <nota>
       */



        /*
        7. Monte a média de todos os alunos e exiba em tela ordenando da maior para a menor nota.
            - Exiba os dados nesse formato: <posicao> - <código> - <nome> : Média = <nota>
         */

        }
    }

    public static void studentsPass(List<Student> Study) {
        System.out.println("Students who passed: \n");
        //Search for grades in the list, create average var, create conditional for success and print on screen
        for (Student studentPass : Study) {
            float avg = (studentPass.getTestOne() + studentPass.getTestTwo() + studentPass.getTestThree()) / 3;
            if (avg >= 7.0) {
                System.out.println(studentPass.getCode() + "-" + studentPass.getName() + ": Média: " + avg);
            }
        }
    }

    public static void studentsFail(List<Student> Study) {
        System.out.println("Students who failed: \n");
        //Search for grades in the list, create average var and create average difference var
        //create conditional for fail and print on screen
        for (Student studentFail : Study) {
            float avg = (studentFail.getTestOne() + studentFail.getTestTwo() + studentFail.getTestThree()) / 3;
            float miss = avg - 7.0f;
            if (avg <= 7.0f) {
                System.out.println(studentFail.getCode() + "-" + studentFail.getName() + ": Média: " + avg);
                System.out.println("Faltou: " + miss);
            }
        }
    }

    public static void highestGrade(List<Student> Study) {
        System.out.println("Students with maximum grade (In this case: 10.0) \n");
        //Search for the grades, compare to find the 10.0 grade with the conditional and print the code and name
        for (Student highGrade : Study) {
            if ((highGrade.getTestOne() == 10.0) || (highGrade.getTestTwo() == 10.0)
                    || (highGrade.getTestThree() == 10.0)) {
                System.out.println(highGrade.getCode() + "-" + highGrade.getName());
            }
        }
    }

    public static void lowestGrade(List<Student> Study) {
        System.out.println("Student with the lowest grade: \n");
        List<Float> grade = new ArrayList<>();

        //Find the smallest grades and put them in a list
        for (Student lowestGrade : Study) {
            float smaller = lowestGrade.getTestOne();
            if (lowestGrade.getTestTwo() < smaller) {
                smaller = lowestGrade.getTestTwo();
            }
            if (lowestGrade.getTestThree() < smaller) {
                smaller = lowestGrade.getTestThree();
            }
            grade.add(smaller);
        }

        //Find the smaller
        float smaller = grade.get(0);
        for (Float lowGrade : grade) {
            if (lowGrade < smaller) {
                smaller = lowGrade;
            }
        }
        //Find the student smaller grade
        for (Student lowestGrade : Study) {
            if (smaller == lowestGrade.getTestOne()) {
                System.out.println(lowestGrade.getCode() + " - " + lowestGrade.getName() + " : Nota = " + lowestGrade.getTestOne());
            } else if (smaller == lowestGrade.getTestTwo()) {
                System.out.println(lowestGrade.getCode() + " - " + lowestGrade.getName() + " : Nota = " + lowestGrade.getTestTwo());
            } else if (smaller == lowestGrade.getTestThree()) {
                System.out.println(lowestGrade.getCode() + " - " + lowestGrade.getName() + " : Nota = " + lowestGrade.getTestThree());
            }
        }
    }

    public static void topThree(List<Student> Study) {
        System.out.println("The 3 best grades per student: \n");
        List<Float> bestGrades = new ArrayList<>();

        //Find the grades and put them in list
        for (Student besThree : Study) {
            bestGrades.add(besThree.getTestOne());
            bestGrades.add(besThree.getTestTwo());
            bestGrades.add(besThree.getTestThree());
        }

        //Finding the highest first grade
        float max1 = bestGrades.get(0);
        for (Float grd1 : bestGrades) {
            if (grd1 > max1) {
                max1 = grd1;
            }
        }

        //Finding the highest second grade
        float max2 = bestGrades.get(0);
        for (Float grd2 : bestGrades) {
            if (grd2 > max2 && grd2 != max1) {
                max2 = grd2;
            }
        }

        //Finding the highest third grade
        float max3 = bestGrades.get(0);
        for (Float grd3 : bestGrades) {
            if (grd3 > max3 && grd3 != max1 && grd3 != max2) {
                max3 = grd3;
            }
        }

        //Find and print the first(s)
        for (Student best1 : Study) {
            if (max1 == best1.getTestOne()) {
                System.out.println("1º - " + best1.getName() + " : Nota = " + best1.getTestOne());
            }if (max1 == best1.getTestTwo()) {
                System.out.println("1º - " + best1.getName() + " : Nota = " + best1.getTestTwo());
            }if (max1 == best1.getTestThree()) {
                System.out.println("1º - " + best1.getName() + " : Nota = " + best1.getTestThree());
            }

        }

        //Find and print the second(s)
        for (Student best2 : Study) {
            if (max2 == best2.getTestOne()) {
                System.out.println("2º - " + best2.getName() + " : Nota = " + best2.getTestOne());
            }if (max2 == best2.getTestTwo()) {
                System.out.println("2º - " + best2.getName() + " : Nota = " + best2.getTestTwo());
            }if (max2 == best2.getTestThree()) {
                System.out.println("2º - " + best2.getName() + " : Nota = " + best2.getTestThree());
            }
        }

        //Find and print the third(s)
        for (Student best2 : Study) {
            if (max3 == best2.getTestOne()) {
                System.out.println("3º - " + best2.getName() + " : Nota = " + best2.getTestOne());
            }if (max3 == best2.getTestTwo()) {
                System.out.println("3º - " + best2.getName() + " : Nota = " + best2.getTestTwo());
            }if (max3 == best2.getTestThree()) {
                System.out.println("3º - " + best2.getName() + " : Nota = " + best2.getTestThree());
            }
        }
    }
    public static void worstThree(List<Student> Study) {
        System.out.println("The 3 worst grades per student: \n");
        List<Float> worstGrades = new ArrayList<>();

        //Find the grades and put them in list
        for (Student worstThree : Study) {
            worstGrades.add(worstThree.getTestOne());
            worstGrades.add(worstThree.getTestTwo());
            worstGrades.add(worstThree.getTestThree());
        }

        //Finding the highest first grade
        float low1 = worstGrades.get(0);
        for (Float grd1 : worstGrades) {
            if (grd1 < low1) {
                low1 = grd1;
            }
        }

        //Finding the highest second grade
        float low2 = worstGrades.get(0);
        for (Float grd2 : worstGrades) {
            if (grd2 < low2 && grd2 != low1) {
                low2 = grd2;
            }
        }

        //Finding the highest third grade
        float low3 = worstGrades.get(0);
        for (Float grd3 : worstGrades) {
            if (grd3 < low3 && grd3 != low1 && grd3 != low2) {
                low3 = grd3;
            }
        }

        //Find and print the first(s)
        for (Student best1 : Study) {
            if (low1 == best1.getTestOne()) {
                System.out.println("1º - " + best1.getName() + " : Nota = " + best1.getTestOne());
            }
            if (low1 == best1.getTestTwo()) {
                System.out.println("1º - " + best1.getName() + " : Nota = " + best1.getTestTwo());
            }
            if (low1 == best1.getTestThree()) {
                System.out.println("1º - " + best1.getName() + " : Nota = " + best1.getTestThree());
            }

        }

        //Find and print the second(s)
        for (Student best2 : Study) {
            if (low2 == best2.getTestOne()) {
                System.out.println("2º - " + best2.getName() + " : Nota = " + best2.getTestOne());
            }
            if (low2 == best2.getTestTwo()) {
                System.out.println("2º - " + best2.getName() + " : Nota = " + best2.getTestTwo());
            }
            if (low2 == best2.getTestThree()) {
                System.out.println("2º - " + best2.getName() + " : Nota = " + best2.getTestThree());
            }
        }

        //Find and print the third(s)
        for (Student best2 : Study) {
            if (low3 == best2.getTestOne()) {
                System.out.println("3º - " + best2.getName() + " : Nota = " + best2.getTestOne());
            }
            if (low3 == best2.getTestTwo()) {
                System.out.println("3º - " + best2.getName() + " : Nota = " + best2.getTestTwo());
            }
            if (low3 == best2.getTestThree()) {
                System.out.println("3º - " + best2.getName() + " : Nota = " + best2.getTestThree());
            }
        }
    }

    public static void allAverages(List<Student> Study){
        System.out.println("List of averages in ascending order, with 1st being the lowest average and 8th being the highest average: \n");
        List<Float> averages = new ArrayList<>();

        //Search for grades in the list, create average var, create conditional for average and put them on a list
        for(Student avg : Study){
            float average = (avg.getTestOne() + avg.getTestTwo() + avg.getTestThree()) / 3;
            averages.add(average);
        }
        //Put the averages in ascending order
        averages.sort(null);
        int position = 1;
        for (Float avgFinal : averages){
            for (Student avg : Study){
                float average = (avg.getTestOne() + avg.getTestTwo() + avg.getTestThree()) / 3;
                if(avgFinal == average){
                    System.out.println(position+"º"+" - "+ avg.getCode()+" - "+ avg.getName()+" : Média = "+average);
                }
            }
            position++;

        }
    }
}