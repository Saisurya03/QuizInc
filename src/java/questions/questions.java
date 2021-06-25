package questions;

public class questions {
    
        private String question;
        private String corr;
        private String stat;
        private int marks;
        private int qid;       
        
    public String getQuestion(){
        return question;
    }
    
    public void setQuestion(String ques){
        this.question = ques;
    }
   
    public String getCorr(){
        return corr;
    }
    
    public void setCorr(String correct){
        this.corr = correct;
    }
    
    public String getStat(){
        return stat;
    }
    
    public void setStat(String status){
        this.stat = status;
    }
   
    public int getMarks(){
        return marks;
    }
    
    public void setMarks(int psw){
        this.marks = psw;
    }
    
    public int getQid(){
        return qid;
    }
    
    public void setQid(int q){
        this.qid = q;
    }
}
