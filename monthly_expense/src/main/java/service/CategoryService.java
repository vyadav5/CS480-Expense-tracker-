package service;

import java.util.List;

import dao.CategoryDao;
import domain.Category;

public class CategoryService {
	private CategoryDao categoryDao = new CategoryDao();

	public void add(Category category)
			throws CustomException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		categoryDao.add(category);
	}

	public void delete(int category_id) {
		categoryDao.delete(category_id);
	}

	public void update(Category category)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		categoryDao.update(category);
	}

	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return categoryDao.findall();
	}

}
