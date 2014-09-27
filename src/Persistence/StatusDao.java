package Persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import Entity.Status;

@Component
public class StatusDao extends Dao {

	public List<Status> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select idStatus, descStatus from status");
		ResultSet rs = stmt.executeQuery();

		List<Status> listaStatus = new ArrayList<Status>();
		while (rs.next()) {
			Status status = new Status();
			status.setIdStatus(rs.getInt("idStatus"));
			status.setDescStatus(rs.getString("descStatus"));
			listaStatus.add(status);
		}
		close();
		return listaStatus;
	}

}
