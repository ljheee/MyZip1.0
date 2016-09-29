package com.ljheee.ziptool.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;


public class ZipTool {
	
	/****解压文件
	 * @throws IOException *****/
	public static void unzip(File inFile,File outFile) throws IOException{
		 ZipFile zipFile = new ZipFile(inFile, "GBK");
		
		Enumeration<ZipEntry> em = zipFile.getEntries();
		
		byte[] buf = new byte[1024*1024];
		
		while(em.hasMoreElements()){
			ZipEntry ze = em.nextElement();
			File outItemFile = new File(outFile,ze.getName());
			if(ze.isDirectory()){
				outItemFile.mkdirs();
			}else{
				InputStream is = zipFile.getInputStream(ze);
				try{
					outFile(outItemFile,is,buf);
				} finally{
					is.close();
				}
			}
			
		}
		
	}
	
	
	
	
	private static void outFile(File outItemFile, InputStream is, byte[] buf) throws IOException {
		outItemFile.getParentFile().mkdirs();
		FileOutputStream fos = new FileOutputStream(outItemFile);
		try{
			int len;
			while((len=is.read(buf))!=-1){
				fos.write(buf, 0, len);
			}
		} finally{
			fos.close();
		}
		
		
	}




	/****压缩文件*****/
	public static void zip(File[] files,File targetFile) throws IOException{
		files = toAbs(files);
		//String parentPath = files[0].getAbsoluteFile().getParent();
		targetFile = targetFile.getAbsoluteFile();//得到绝对路径
		String parentPath = files[0].getParent()+"\\";//得到父路径
		//System.out.println(targetFile );
		//System.out.println(files[0].toString().replace(parentPath, ""));
		files = eachFiles(files);
		ZipOutputStream zos = new ZipOutputStream(targetFile);
		zos.setEncoding("GBK");
		try{
			byte[] buf = new byte[1024*1024];
		for(File f:files){
			//System.out.println(f);
			zipFile(f,zos,parentPath,buf);
		}
		} finally{
			zos.close();
		}
	}

	private static void zipFile(File f, ZipOutputStream zos, String parentPath, byte[] buf) throws IOException {
		String filename = f.toString().replace(parentPath, "");
		if(f.isDirectory()){//关键
			filename+="/";
		}
		ZipEntry ze = new ZipEntry(filename);
		zos.putNextEntry(ze);
		try{
		if(f.isFile()){
			doZip(f,zos,buf);
		}
		}finally{
		zos.closeEntry();
		}
	}

	private static void doZip(File f, ZipOutputStream zos, byte[] buf) throws IOException {
		FileInputStream fis = new FileInputStream(f);
		int len;
		try{
		while((len=fis.read(buf))!=-1){
			zos.write(buf, 0, len);
		}
		}finally{
			fis.close();
		}
		
	}

	private static File[] eachFiles(File[] files) {
		List<File>  list = new ArrayList<>();
		LinkedList<File> tasks = new LinkedList<File>(Arrays.asList(files));
		while( !tasks.isEmpty() ) {
		//	System.out.println(tasks);
			File task = tasks.remove();
			list.add(task);
			System.out.println(task+"-----开始");
			if( !task.isDirectory() ) {
				System.out.println(task+"-----wen结束");
				continue;
			}
			for( File c : task.listFiles() ) {
				tasks.add(c);
			}
			System.out.println(task+"-----结束");
		}
		
		return list.toArray(new File[0]);
	}

	private static File[] toAbs(File[] files) {
		ArrayList<File> list = new ArrayList<>();
		for(File f:files){
			list.add(f.getAbsoluteFile());
		}
		return list.toArray(new File[0]);
	}
	
}