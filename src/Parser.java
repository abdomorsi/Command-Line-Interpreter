import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Parser {
    String[] args;
    String cmd;

    // verifying user cmd and args
    boolean verifying (String userCmd, ArrayList<String> userArgs) {
        ArrayList<String> one = new ArrayList<String>(Arrays.asList("cd","mkdir","rmdir","rm","cat","more"));
        ArrayList<String> zero = new ArrayList<String>(Arrays.asList("ls","date","pwd","clear"));
        ArrayList<String> two = new ArrayList<String>(Arrays.asList("cat","more","cp","mv"));
        if(one.contains(userCmd))
            return (userArgs.size()==1);
        else if(zero.contains(userCmd))
            return (userArgs.size()==0);
        else if(two.contains(userCmd))
            return (userArgs.size()==2);
        else return false;
    }
    /// check if the user input is could parsed (canParse)
    private boolean canParse(String checkString) {
        String tempCmd="";
        String temp="";
        ArrayList<String> tembArgs=new ArrayList<String>();
        boolean flag = false;
        for (int i=0;i<checkString.length();i++) {
            if(checkString.charAt(i)==' ' || i==checkString.length()-1){
                if(flag == false) {
                    flag = true;
                    tempCmd = temp;
                    temp = "";
                }else {
                    tembArgs.add(temp);
                    temp = "";
                }
            }else
                temp += checkString.charAt(i);
        }
        if (verifying(tempCmd, tembArgs)) {
            cmd = tempCmd;
            for (String s:tembArgs) {
                Arrays.asList(args).add(s);
            }
        }
        return verifying(tempCmd,tembArgs);
    }

    public boolean parse(String input){
        String temp="";
        for (int i=0;i<input.length();i++) {
            if (input.charAt(i) != '|') {
                temp += input.charAt(i);
            } else {
                temp = temp.trim();
                if (canParse(temp)) {
                    // accept (user input)

                } else {
                    // error message
                }

            }

        }
        return false;
    }
    public String getCmd(){
        return cmd;
    }
    public String[] getArgument(){
        return args;
    }

}
