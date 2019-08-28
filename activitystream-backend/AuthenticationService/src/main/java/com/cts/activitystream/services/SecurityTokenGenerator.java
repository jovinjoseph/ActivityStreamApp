package com.cts.activitystream.services;

import java.util.Map;

import com.cts.activitystream.domain.User;

public interface SecurityTokenGenerator {
	Map<String, String> generateToken(User user);
}
