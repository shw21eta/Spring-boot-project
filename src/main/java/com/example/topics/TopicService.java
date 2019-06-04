package com.example.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1", "science", "general science"),
			new Topic("2", "Core java", "Core java description"),
			new Topic("3", "php", "php description")				
			));
	
	public List<Topic> getAllTopics(){
//		return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id) {
//		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
//		topics.add(topic);
		topicRepository.save(topic);
		
	}
	
	public void updateTopic(String id,Topic topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
//		topics.removeIf(t-> t.getId().equals(id));
		topicRepository.delete(id);
	}
}
