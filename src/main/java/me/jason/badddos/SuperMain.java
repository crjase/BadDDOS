package me.jason.badddos;




// For it to be able to find the Main Class
// The jar needs to know the actual Main class that does NOT extend Application
public class SuperMain {

    public static void main(String[] args) {
        Application.main(args);
    }

}
