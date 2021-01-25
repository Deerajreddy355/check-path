package com.mc.path.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CheckPathService {

	@Qualifier("paths")
	@Autowired
	public Map<String, String> paths;

	public String checkIfConnected(String origin, String destination) {
		Map<String, String> connectionMap = paths;
		String source = origin;
		while (connectionMap.containsKey(source)) {
			source = connectionMap.get(source);
			if (source.equals(destination)) {
				return "yes";
			}
		}
		return "no";
	}
}
