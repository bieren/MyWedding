package com.sp.utils;

public class IdWorker {

	private final long workerId;
	
	private final static long twepoch = 1361753741828L;
	
	private long sequence = 0L;
	
    private final static long workerIdBits = 12L;
	
	public final static long maxWorkerId = -1L ^ -1L << workerIdBits;
	
	private final static long sequenceBits = 10L;
	
	private final static long workerIdShift = sequenceBits;
	
	private final static long timestampLeftShift = sequenceBits + workerIdBits;
	
	public final static long sequenceMask = -1L ^ -1L << sequenceBits;
	 
	private long lastTimestamp = -1L;
	 
	public IdWorker() {
		super();
		this.workerId = PropertiesUtils.getIntValue("work_id");
	}
	
	public IdWorker(final long workerId) {
		super();
		if (workerId > this.maxWorkerId || workerId < 0) 
		{
			throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",this.maxWorkerId));
		}
		this.workerId = workerId;
	}
	
	public synchronized long nextId() {
		long timestamp = this.timeGen();
		if (this.lastTimestamp == timestamp) 
		{
			this.sequence = (this.sequence + 1) & this.sequenceMask;
			if (this.sequence == 0) {
				System.out.println("###########" + sequenceMask);
				timestamp = this.tilNextMillis(this.lastTimestamp);
	    	}
	    } 
		else 
		{
	    	this.sequence = 0;
	    }
		if (timestamp < this.lastTimestamp) 
		{
			try {
				throw new Exception(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",this.lastTimestamp - timestamp));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	}
	    }
		this.lastTimestamp = timestamp;
		long nextId = ((timestamp - twepoch << timestampLeftShift))| (this.workerId << this.workerIdShift) | (this.sequence);
		return nextId;
	 }
	 

	 private long tilNextMillis(final long lastTimestamp) {

		 long timestamp = this.timeGen();
		 while (timestamp <= lastTimestamp) {
			 timestamp = this.timeGen();
			 }
		 return timestamp;
	 }
	 
	 private long timeGen() {
		 return System.currentTimeMillis();
	 }
	  
	 public static void main(String[] args){
		 IdWorker worker1 = new IdWorker(1);
		 IdWorker worker2 = new IdWorker(2);
		 for(int i=0;i<10;i++)
		 {
			 System.out.println(worker2.nextId());
			 System.out.println(worker1.nextId());
		 }
	 }
	 
}
