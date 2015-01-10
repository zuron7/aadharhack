package com.aadhar.mongo;

import java.net.UnknownHostException;
import java.time.Period;
import java.time.Year;

import com.aadhar.lib.Attendance;
import com.aadhar.lib.Clas;
import com.aadhar.lib.Schedule;
import com.aadhar.lib.Student;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class DBManager {
	private String ip;
	private int port;
	private String username;
	private String password;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addStudent(Student s) {
		try {
			MongoClient cli = new MongoClient(this.ip, this.port);
			DB db = cli.getDB("aadhaar");
			BasicDBObject obj = new BasicDBObject("name", s.getName())
					.append("id", s.getId()).append("clas", s.getClas())
					.append("aadhaarId", s.getAadhaarId());
			DBCollection coll = null;
			if (!db.collectionExists("student")) {
				coll = db.createCollection("student", obj);
				coll = db.getCollection("student");
			} else {
				coll = db.getCollection("student");
			}
			coll.insert(obj, WriteConcern.ACKNOWLEDGED);
			cli.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addClass(Clas c) {
		try {
			MongoClient cli = new MongoClient(this.ip, this.port);
			DB db = cli.getDB("aadhaar");
			BasicDBObject obj = new BasicDBObject("id", c.getId()).append(
					"name", c.getName());
			DBCollection coll = null;
			if (!db.collectionExists("clas")) {
				coll = db.createCollection("clas", obj);
				coll = db.getCollection("clas");
			} else {
				coll = db.getCollection("clas");
			}
			coll.insert(obj, WriteConcern.ACKNOWLEDGED);
			cli.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addAttendance(Attendance a) {
		try {
			MongoClient cli = new MongoClient(this.ip, this.port);
			DB db = cli.getDB("aadhaar");
			BasicDBObject obj = new BasicDBObject("studentId", a.getStudentId())
					.append("year", new Integer(a.getYear()))
					.append("week", new Integer(a.getWeek()))
					.append("day", new Integer(a.getDay()))
					.append("period", new Integer(a.getPeriod()));
			DBCollection coll = null;
			if (!db.collectionExists("attendance")) {
				coll = db.createCollection("attendance", obj);
				coll = db.getCollection("attendance");
			} else {
				coll = db.getCollection("attendance");
			}
			if (coll.getCount(obj) > 0) {
				cli.close();
				return;
			}
			coll.insert(obj, WriteConcern.ACKNOWLEDGED);
			cli.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public DBObject getStudentRecordFromStudentId(String studentId) {
		try {
			MongoClient cli = new MongoClient(this.ip, this.port);
			DB db = cli.getDB("aadhaar");
			DBCollection coll = null;
			if (!db.collectionExists("student")) {
				cli.close();
				return null;
			}
			coll = db.getCollection("student");
			BasicDBObject obj = new BasicDBObject();
			obj.append("id", studentId);
			DBObject res = coll.findOne(obj);
			if (res == null) {
				cli.close();
				return null;
			}
			return res;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public DBObject getStudentRecordFromAadhaarId(String aadhaarId) {
		try {
			MongoClient cli = new MongoClient(this.ip, this.port);
			DB db = cli.getDB("aadhaar");
			DBCollection coll = null;
			if (!db.collectionExists("student")) {
				cli.close();
				return null;
			}
			coll = db.getCollection("student");
			BasicDBObject obj = new BasicDBObject();
			obj.append("aadhaarId", aadhaarId);
			DBObject res = coll.findOne(obj);
			if (res == null) {
				cli.close();
				return null;
			}
			return res;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public long getStudentAttendance(int day, int period) {
		try {
			MongoClient cli = new MongoClient(this.ip, this.port);
			DB db = cli.getDB("aadhaar");
			DBCollection coll = null;
			if (!db.collectionExists("attendance")) {
				cli.close();
				return 0;
			}
			coll = db.getCollection("attendance");
			BasicDBObject obj = new BasicDBObject();
			obj.append("day", new Integer(day)).append("period",
					new Integer(period));
			long count = coll.getCount(obj);
			cli.close();
			return count;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void addSchedule(Schedule s) {
		try {
			MongoClient cli = new MongoClient(this.ip, this.port);
			DB db = cli.getDB("aadhaar");
			DBCollection coll = null;
			if (!db.collectionExists("schedule")) {
				cli.close();
				return;
			}
			coll = db.getCollection("schedule");
			BasicDBObject obj = new BasicDBObject();
			obj.append("day", new Integer(s.getDay())).append("period",
					new Integer(s.getPeriod()));
			BasicDBObject obju = new BasicDBObject();
			obju.append("day", new Integer(s.getDay()))
					.append("period", new Integer(s.getPeriod()))
					.append("subject", new Integer(s.getSubject()));

			if (coll.getCount(obj) > 0) {
				coll.update(obj, obju);
			} else {
				coll.insert(obju, WriteConcern.ACKNOWLEDGED);
			}
			cli.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
