package in.ashokit.service;
import java.util.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import in.ashokit.domain.City;
import in.ashokit.domain.Country;
import in.ashokit.domain.State;
import in.ashokit.domain.UnlockAccount;
import in.ashokit.domain.User;
import in.ashokit.resource.CityRepository;
import in.ashokit.resource.CountryRepository;
import in.ashokit.resource.StateRepository;
import in.ashokit.resource.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepo;
	private CountryRepository countryRepo;
	private StateRepository stateRepo;
	private CityRepository cityRepo;
	
	public UserServiceImpl(UserRepository userRepo, CountryRepository countryRepo, StateRepository stateRepo, CityRepository cityRepo ) {
		// TODO Auto-generated constructor stub
		this.userRepo = userRepo;
		this.countryRepo = countryRepo;
		this.stateRepo = stateRepo;
		this.cityRepo = cityRepo;
	}
	
	@Override
	public Map<Integer, String> getCountries(){
		List<Country> countryList= countryRepo.findAll();
		Map<Integer, String> countryMap = new HashMap<>();
        for (Country country : countryList) {
        	countryMap.put(country.getCountryId(), country.getCountryName());
        }
		return countryMap;
	}
	@Override
	public Map<Integer, String> getStates(Integer countryId){
		List<State> stateList = stateRepo.findStatesByCountryId(countryId);
		Map<Integer, String> stateMap = new HashMap<>();
        for (State state : stateList) {
        	stateMap.put(state.getStateId(), state.getStateName());
        }
		return stateMap;
	}
	@Override
	public Map<Integer, String> getCities(Integer stateId){
		List<City> cityList = cityRepo.findCitiesByStateId(stateId);
		Map<Integer, String> cityMap = new HashMap<>();
        for (City city : cityList) {
        	cityMap.put(city.getCityId(), city.getCityName());
        }
		return cityMap;
	}
	@Override
	public User getUserByEmail(String email) {
	    User user = userRepo.findUserByEmailId(email);
		return user!=null?user:null;
	}
	@Override
	public Boolean saveUser(User user) {
		user.setAccStatus("Locked");
		String tempPassword = generateRandomPassword(6,14);
		user.setUserPwd(tempPassword);
		User userSave = userRepo.save(user);
		return userSave.getUserId() != null;
		/*User user = getUserByEmail(user.getUserEmail());
		if(user != null){
			user.setAccStatus("Locked");
			String tempPassword = generateRandomPassword(6,14);
			user.setUserPwd(tempPassword);
			User userSave = userRepo.save(user);
			return true;
		}
		else {
			return false;
			// message to display if registered user trying to registered again-email duplicate
		}
		*/
	}
	 // Method to generate a random alphanumeric password of a specific length
	public static String generateRandomPassword(int start, int end) {
        return RandomStringUtils.randomAlphabetic(start, end);
    }
	@Override
	public Boolean forgotPassword(String email) {
		return getUserByEmail(email)!=null;
		//return userRepo.findUserByEmailId(email)!=null?true:false;     
	}
	
	@Override
	public String loginCheck(String email, String pwd) {
		String msg = "";
		User user = new User();
		if(userRepo.existsById(email) && userRepo.existsById(pwd)) {
			if("UnLocked".equals(user.getAccStatus())) {
				msg = "LoginSuccess";
			}
			else msg = "AccountLocked";
		}
		else {
			msg = "InvalidCredintials";
		}
		return msg;
	}
	
	@Override
	public String unlockAccount(UnlockAccount acc) {
		User user = new User();
		Boolean isValid = isTempPwdValid(user.getUserEmail(), acc.getTempPassword());
		if(isValid) {
			if(acc.getNewPassword().equals(acc.getConfirmPassword())) {			
				user.setUserPwd(acc.getNewPassword());
				user.setAccStatus("Unlocked");
			}
		}
		return userRepo.save(user)!=null?"AccountUnlocked!Pleaselogin":"";
		
	}
	private boolean isTempPwdValid(String email, String tempPwd) {
		User user = userRepo.findUserByEmailId(email);
		if(tempPwd == user.getUserPwd()) {
			return true;
		}
		return false;
	}
}
