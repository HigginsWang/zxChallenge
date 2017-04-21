package fileProcess;

import java.util.ArrayList;
import java.util.List;

public class ReadFileResultData
{
	public int n;
	public int m;
	public List<Edge> edgeList = new ArrayList<Edge>();
	public int k;
	public int t;
	public List<Integer> mustPastNodeList = new ArrayList<Integer>();
	public int x;
	public List<Integer> mustPastEdgeList = new ArrayList<Integer>();
	public int s;
	public List<Integer> mustNotPastEdgeList = new ArrayList<Integer>();
	public int value;
	public void printf()
	{
		System.out.println(n);
		System.out.println(m);
		for(int i = 0 ;i < edgeList.size() ; i++)
		{
			System.out.println(edgeList.get(i).v1+","+edgeList.get(i).v2+","+edgeList.get(i).w);
		}
		System.out.println(k);
		System.out.println(t);
		for(int i = 0 ; i < mustPastNodeList.size(); i++)
		{
			System.out.println(mustPastNodeList.get(i));
		}
		System.out.println(x);
		for(int i = 0 ; i < mustPastEdgeList.size(); i++)
		{
			System.out.println(mustPastEdgeList.get(i));
		}
		System.out.println(s);
		for(int i = 0 ; i < mustNotPastEdgeList.size(); i++)
		{
			System.out.println(mustNotPastEdgeList.get(i));
		}
		System.out.println(value);
	}
}
