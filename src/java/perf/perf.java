package perf;

public class perf {
    
        private String sname;
        private String status;
        private int totalmarks;
        private int score;
        private int sid;       
        
    public String getSname(){
        return sname;
    }
    
    public void setSname(String s){
        this.sname = s;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String st){
        this.status = st;
    }
   
    public int getTMarks(){
        return totalmarks;
    }
    
    public void setTMarks(int tm){
        this.totalmarks = tm;
    }
    public int getScore(){
        return score;
    }
    
    public void setScore(int sc){
        this.score = sc;
    }
    public int getSid(){
        return sid;
    }
    
    public void setSid(int Sid){
        this.sid = Sid;
    }
}
