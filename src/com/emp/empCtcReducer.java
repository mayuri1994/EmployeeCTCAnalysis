package com.emp;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class empCtcReducer extends Reducer<Text, Text, NullWritable,Text>{

	public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException {
		int maxctc=Integer.MIN_VALUE;
	int ctc=0;
	String value = null;
	for(Text val :values) {
		ctc=Integer.parseInt(val.toString().split("\\t")[5]);
		if(ctc>maxctc) {
			maxctc=ctc;
			value=val.toString();
		}
	}
	context.write(NullWritable.get(), new Text(value));
	
	}
	
}
