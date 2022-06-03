package service;

import java.util.List;

import dao.SavingDao;
import domain.Saving;

public class SavingService {
	private SavingDao savingDao = new SavingDao();

	public void add(Saving saving)
			throws CustomException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		savingDao.add(saving);
	}

	public void delete(int saving_id) {
		savingDao.delete(saving_id);
	}

	public void update(Saving saving) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		savingDao.update(saving);
	}

	public List<Object> findSavings(String email)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return savingDao.findSavings(email);

	}

	public List<Object> findCustomSaving(String date, String email)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return savingDao.findCustomSaving(date, email);
	}

}
