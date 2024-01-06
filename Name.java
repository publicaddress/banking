import java.io.*;
import java.util.*;

public class Name {
	public String first (ArrayList<String> data){
		String[] subs = data.split(" ", 0);
        first = (subs[0]);

        return(first);
	}

		public String last (ArrayList<String> data){
		String[] subs = data.split(" ", 0);
        last = (subs[1]);

        return(last);
	}
}
