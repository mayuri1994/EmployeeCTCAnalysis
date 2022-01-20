package com.emp;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class empCtcMapper extends Mapper<Object,Text,Text,Text> {

public void map(Object key,Text value,Context context) throws IOException, InterruptedException 
{
	String[] token=value.toString().split("\\t");
//	context.write(new Text(token[4]), value);
	context.write(new Text(token[4]+" "+token[3]), value);

}	
}
