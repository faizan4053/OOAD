import java.io.*; 

interface Sports{
        int grace=30;
        
}
class Student implements Sports{
       
        public int marks;
       
        
        Student(){
                this.marks=0;
        }   
}


class Exam extends Student{
        public int examMarks;  
}

class Results extends Exam{
        private int maxMarks=100;
        private int totalMarks=0;
        public static int finalMarks(Results x){
                if(x.totalMarks>x.maxMarks) return(x.maxMarks);
                else return(x.totalMarks);
        }
        public static void main(String[] args){
                Results obj=new Results();
                obj.examMarks=Integer.parseInt(args[1]);
                if(Integer.parseInt(args[0])==1){
                obj.marks=obj.marks+grace;
                }
               
                obj.totalMarks=obj.marks+obj.examMarks;
                obj.totalMarks=finalMarks(obj);
                System.out.println(obj.totalMarks);
        }
        
}
