package com.emp;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;


public class empCtcDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Configuration conf=new Configuration();
		String OtherArgs[]=new GenericOptionsParser(conf,args).getRemainingArgs();
		Job job=new Job(conf,"Eployee ctc");
		job.setJobName("Emplyee ctc job");
		job.setJarByClass(empCtcDriver.class);
		job.setMapperClass(empCtcMapper.class);
		job.setReducerClass(empCtcReducer.class);
		job.setPartitionerClass(empCtcPartitioner.class);
		
		job.setNumReduceTasks(3);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		
		
		FileInputFormat.addInputPath(job, new Path(OtherArgs[0]));
		
		FileOutputFormat.setOutputPath(job, new Path(OtherArgs[1]));
		System.exit(job.waitForCompletion(true)?0:1);
		
		
		
		
	}

}
