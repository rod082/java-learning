package com.learning.lombok;

import lombok.Data;

@Data
public class TopicDetails {

	private String name;
	private int partitions;
	private long retention;
	private int replicas;
}
