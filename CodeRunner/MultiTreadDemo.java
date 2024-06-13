class MultiThreadDemo {
    
    public static void main(String[] args) {
        System.out.println("==Application started==");
//        Thread t1 = new Thread(new MyTask());
//        Thread t2 = new Thread(new YourTask());
//        t1.start();
//        t2.start();
        Printer p1 = new Printer();
        MyThread mt1 = new MyThread(p1);
        YourThread yt1 = new YourThread(p1);
        mt1.start();
        
        yt1.start();
        
        
        
        System.out.println("==Application finished==");
    }
}

class MyTask implements Runnable{
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println("###Printer1");		
        }

    }
}

class YourTask implements Runnable{
    public void run(){
        for(int i = 1; i < 10 + 1; i ++){
            System.out.println("&&&Printer2");
        }
        
    }
}

class MyThread extends Thread{
    
    Printer p;
    
    MyThread(Printer p){
        this.p = p;
    }
    
    @Override
    public void run(){
        synchronized (p){
            p.printDocu(10, "John's_Document.pdf");
        }
    }
}

class YourThread extends Thread{
    Printer p;
    
    YourThread(Printer p){
        this.p = p;
    }
    
    @Override
    public void run(){
        synchronized (p){
            p.printDocu(10, "Fionna's_Document.pdf");
        }
    }
}

class Printer{
//    synchronized public void printDocu(int count, String docuName){
        public void printDocu(int count, String docuName){
            
            for(int i = 1; i < count + 1; i++){
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    
                }
                System.out.println("Printing " + docuName +" #" + i);
            }
    }
}