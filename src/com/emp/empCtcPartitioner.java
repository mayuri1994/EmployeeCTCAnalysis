package com.emp;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class empCtcPartitioner extends Partitioner<Text,Text>{

	@Override
	public int getPartition(Text key, Text value, int noofReducerTasks) {
		// TODO Auto-generated method stub
		int partitionno=0;
		/*
		 * String gender=value.toString().split("\\t")[3]; if(noofReducerTasks>0) {
		 * if(gender.equals("female")) { partitionno=0; } else { partitionno=1; } }
		 */
		int age=Integer.parseInt(value.toString().split("\\t")[2]); 
		if(noofReducerTasks>0) 
		{
			if(age>=20 && age<=30) 
			{ 
				partitionno=0; 
			} 
			else if(age>30 && age<=50) 
			{
				partitionno=1; 
			}
			else if(age>50 && age<=80) 
			{
			partitionno=2;
			}
		}
		return partitionno;
	}

}
