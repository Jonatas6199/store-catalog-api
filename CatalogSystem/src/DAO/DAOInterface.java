package DAO;
import java.util.ArrayList;

public interface DAOInterface<DomainObject> {
		
	public  void insert(DomainObject obj);
	public  void update(DomainObject obj);
	public  void delete(DomainObject obj);
	public  DomainObject find(DomainObject obj);
	public  ArrayList<DomainObject> findAll(DomainObject obj);
}