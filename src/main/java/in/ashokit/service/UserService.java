package in.ashokit.service;

import java.util.Map;

import in.ashokit.domain.UnlockAccount;
import in.ashokit.domain.User;

public interface UserService {
	
	public String loginCheck(String email, String pwd);
	public Map<Integer, String> getCountries();
	public Map<Integer, String> getStates(Integer countryId);
	public Map<Integer, String> getCities(Integer stateId);
	public User getUserByEmail(String email);
	public Boolean saveUser(User user);
	public String unlockAccount(UnlockAccount acc);
	public Boolean forgotPassword(String email);
	
}
