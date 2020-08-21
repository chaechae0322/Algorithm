/*
 * 2020.04.06
 * 트리 구조 디렉토리 구현
 * Tree
 * mkdir, cp, rm 명령어 구현
 */

package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Line6 {
	public static class Node implements Comparable<Node>{
		String name;
		ArrayList<Node> child;
		
		public Node(String name) {
			super();
			this.name = name;
			this.child = new ArrayList<>();
		}
		
		public void addChild(Node child) {
			this.child.add(child);
			Collections.sort(this.child);
		}
		
		public void delChild(Node child) {
			this.child.remove(child);
		}

		@Override
		public int compareTo(Node o) {
			return this.name.compareTo(o.name);
		}
		
	}
	public static void main(String[] args) {
		String[] directory = {
				"/",
				"/hello",
				"/hello/tmp",
				"/root",
				"/root/abcd",
				"/root/abcd/etc",
				"/root/abcd/hello"
		};
		
		String[] command = {
				"mkdir /root/tmp",
				"cp /hello /root/tmp", 
				"rm /hello"
		};

		Node root = new Node("");
		for(int i=0; i<directory.length; i++) {
			mkdir(root, directory[i]);
		}
		
		for(int i=0; i<command.length; i++) {
			String[] sp = command[i].split(" ");
			if(sp[0].equals("mkdir")) {
				mkdir(root, sp[1]);
			} else if(sp[0].equals("cp")) {
				cp(root, sp[1], sp[2]);
			} else if(sp[0].equals("rm")) {
				rm(root, sp[1]);
			}
		}
		
		ArrayList<String> pathList = new ArrayList<>();
		travers(root, pathList, "");
		
		String[] answer = new String[pathList.size()];
		for(int i=0; i<pathList.size(); i++) {
			answer[i]=pathList.get(i);
			System.out.println(answer[i]);
		}
	}
	
	public static void mkdir(Node root, String dst) {
		String[] dirs = dst.split("/");
		
		Node tmp = root;
		boolean isfind=false;
		loop : for(int j=1; j<dirs.length; j++) {
			/*if(!tmp.child.contains(dirs[j])) {
				tmp.addChild(new Node(dirs[j]));
				continue;
			}*/
			isfind=false;
			for(int k=0; k<tmp.child.size(); k++) {
				if(tmp.child.get(k).name.equals(dirs[j])) {
					tmp = tmp.child.get(k);
					isfind=true;
					continue loop;
				}
			}
			if(!isfind) {
				tmp.addChild(new Node(dirs[j]));
				continue;
			}
		}
	}
	
	public static void cp(Node root, String src, String dst) {
		String[] dirs = src.split("/");
		Node copyfrom = root;
		loop : for(int i=1; i<dirs.length; i++) {
			for(int k=0; k<copyfrom.child.size(); k++) {
				if(copyfrom.child.get(k).name.equals(dirs[i])) {
					copyfrom = copyfrom.child.get(k);
					continue loop;
				}
			}
		}
		
		Node copyto = root;
		dirs = dst.split("/");
		loop : for(int i=1; i<dirs.length; i++) {
			for(int k=0; k<copyto.child.size(); k++) {
				if(copyto.child.get(k).name.equals(dirs[i])) {
					copyto = copyto.child.get(k);
					continue loop;
				}
			}
		}
		
		copyto.addChild(copyfrom);
		
	}
	
	public static void rm(Node root, String dst) {
		System.out.println(dst);
		String[] dirs = dst.split("/");
		Node pre = null;
		Node delNode = root;
		loop : for(int i=1; i<dirs.length; i++) {
			System.out.println(dirs[i]);
			for(int k=0; k<delNode.child.size(); k++) {
				if(delNode.child.get(k).name.equals(dirs[i])) {
					System.out.println("hhd");
					pre = delNode;
					delNode = delNode.child.get(k);
					continue loop;
				}
			}
		}
		
		System.out.println(delNode.name);
		pre.delChild(delNode);
	}
	
	public static void travers(Node node, ArrayList<String> pathList, String path) {
		if(pathList.size()==0) {
			pathList.add("/");
		}
		else {
			path= path.concat("/"+node.name);
			pathList.add(path);
		}
		//System.out.println("path:"+path);
		for(int i=0; i<node.child.size(); i++) {
			travers(node.child.get(i), pathList, path);
		}
	}

}
