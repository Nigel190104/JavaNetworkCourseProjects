//this actually part 2

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        //the internet address class get all by name method will return teh ip address for a given url
        InetAddress[] names = InetAddress.getAllByName("techbinz.com");
        //if there were theoreticlayh multiple ips assocaiate with teh name specifed
        //techbinz then there would be mutliple ips printed in the precedding for lopp
        //however only one is returned so it could be said that there is only
        //ip addresss assoicated with the name specified
        for(InetAddress name : names){
           System.out.println(name);
        }


        InetAddress myaddress = InetAddress.getByName("techbinz.com");
        //the line below is asking if it is the local or global address of the webste
        //it will return no which means it is ther global
        // and yes which doesnt happen in this instance if it was their local
        if(myaddress.isAnyLocalAddress()){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}