package maxPalindrome;

import java.util.List;

public interface Dao<T> {
	void save(T t);
	List<T> get (int id);
	
	void update(T t, String[] params);
	
	void delete(T t);
}

class ABC implements Dao<String>{

	@Override
	public void save(String t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String t) {
		// TODO Auto-generated method stub
		
	}
	
}