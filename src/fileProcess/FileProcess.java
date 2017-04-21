package fileProcess;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class FileProcess {
	
	public static final int FILE_FORMAT_UNVALID = 0x0000;//文件格式正确
	public static final int FILE_FORMAT_VALID = 0x0001;//文件格式不正确
	public static final int FILE_READ_EXCEPTIONOCCUR = 0x0002;
	
	public static ReadFileResultData ReadFile(File file)
	{
		ReadFileResultData result = new ReadFileResultData();
		FileReader fr = null;
		BufferedReader br = null;
		String tempString = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			result.n = Integer.valueOf(br.readLine());
			if(result.n<=0){result.value = FILE_FORMAT_UNVALID;return result;}
			
			result.m = Integer.valueOf(br.readLine());
			if(result.m<=0){result.value = FILE_FORMAT_UNVALID;return result;}
			
			for(int i = 0 ; i < result.m ; i++)
			{
				tempString = br.readLine();
				String EdgeString[] = tempString.split(" ");
				if(EdgeString.length!=3){result.value = FILE_FORMAT_UNVALID; return result;}
				int v1 = Integer.valueOf(EdgeString[0]); int v2 = Integer.valueOf(EdgeString[1]); int w = Integer.valueOf(EdgeString[2]);
				if(v1<0||v2<0||v1>=result.n||v2>=result.n||w<=0){result.value = FILE_FORMAT_UNVALID; return result;}
				Edge edge = new Edge(v1,v2,w);
				result.edgeList.add(edge);
			}
			result.k = Integer.valueOf(br.readLine());
			System.out.println(result.k);
			if(result.k<0||result.k>result.n){result.value = FILE_FORMAT_UNVALID; return result;}
			result.t = Integer.valueOf(br.readLine());
			System.out.println(result.t);
			if(result.t<0||result.t>result.n){result.value = FILE_FORMAT_UNVALID; return result;}
			for(int i = 0 ; i < result.t ; i++){
				int mustPastNodeIndex = Integer.valueOf(br.readLine());
				System.out.println(mustPastNodeIndex);
				if(mustPastNodeIndex<=0||mustPastNodeIndex>=result.n-1){result.value = FILE_FORMAT_UNVALID; return result;}
				result.mustPastNodeList.add(mustPastNodeIndex);
			}
			result.x = Integer.valueOf(br.readLine());
			if(result.x<0||result.x>result.m){result.value = FILE_FORMAT_UNVALID; return result;}
			for(int i = 0 ; i < result.x ; i++)
			{
				int eb = Integer.valueOf(br.readLine());
				if(eb<0||eb>=result.m){result.value = FILE_FORMAT_UNVALID; return result;}
				result.mustPastEdgeList.add(eb);
			}
			result.s = Integer.valueOf(br.readLine());
			if(result.s<0||result.s>result.m){result.value = FILE_FORMAT_UNVALID; return result;}
			for(int i = 0 ; i < result.s ; i++)
			{
				int eub = Integer.valueOf(br.readLine());
				if(eub<0||eub>=result.m){result.value = FILE_FORMAT_UNVALID; return result;}
				result.mustNotPastEdgeList.add(eub);
			}
			result.value = FILE_FORMAT_VALID;
		} catch (Exception e) {
			result.value = FILE_READ_EXCEPTIONOCCUR;
		}
		return result;
	}
	
}
