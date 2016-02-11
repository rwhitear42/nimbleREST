package com.rwhitear.nimbleRest.volumeCollections.json;

public class VolCollectionsDetailDataScheduleList {

	private long at_time;
	private String days;
	private boolean disable_appsync;
	private String downstream_partner;
	private String downstream_partner_id;
	private String downstream_partner_name;
	private int num_retain;
	private int num_retain_replica;
	private int period;
	private String period_unit;
	private long repl_alert_thres;
	private long replicate_every;
	private String schedule_id;
	private String schedule_name;
	private String schedule_type;
	private boolean skip_db_consistency_check;
	private boolean snap_verify;
	private long until_time;
	
	
	public long getAt_time() {
		return at_time;
	}
	public void setAt_time(long at_time) {
		this.at_time = at_time;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public boolean isDisable_appsync() {
		return disable_appsync;
	}
	public void setDisable_appsync(boolean disable_appsync) {
		this.disable_appsync = disable_appsync;
	}
	public String getDownstream_partner() {
		return downstream_partner;
	}
	public void setDownstream_partner(String downstream_partner) {
		this.downstream_partner = downstream_partner;
	}
	public String getDownstream_partner_id() {
		return downstream_partner_id;
	}
	public void setDownstream_partner_id(String downstream_partner_id) {
		this.downstream_partner_id = downstream_partner_id;
	}
	public String getDownstream_partner_name() {
		return downstream_partner_name;
	}
	public void setDownstream_partner_name(String downstream_partner_name) {
		this.downstream_partner_name = downstream_partner_name;
	}
	public int getNum_retain() {
		return num_retain;
	}
	public void setNum_retain(int num_retain) {
		this.num_retain = num_retain;
	}
	public int getNum_retain_replica() {
		return num_retain_replica;
	}
	public void setNum_retain_replica(int num_retain_replica) {
		this.num_retain_replica = num_retain_replica;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getPeriod_unit() {
		return period_unit;
	}
	public void setPeriod_unit(String period_unit) {
		this.period_unit = period_unit;
	}
	public long getRepl_alert_thres() {
		return repl_alert_thres;
	}
	public void setRepl_alert_thres(long repl_alert_thres) {
		this.repl_alert_thres = repl_alert_thres;
	}
	public long getReplicate_every() {
		return replicate_every;
	}
	public void setReplicate_every(long replicate_every) {
		this.replicate_every = replicate_every;
	}
	public String getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(String schedule_id) {
		this.schedule_id = schedule_id;
	}
	public String getSchedule_name() {
		return schedule_name;
	}
	public void setSchedule_name(String schedule_name) {
		this.schedule_name = schedule_name;
	}
	public String getSchedule_type() {
		return schedule_type;
	}
	public void setSchedule_type(String schedule_type) {
		this.schedule_type = schedule_type;
	}
	public boolean isSkip_db_consistency_check() {
		return skip_db_consistency_check;
	}
	public void setSkip_db_consistency_check(boolean skip_db_consistency_check) {
		this.skip_db_consistency_check = skip_db_consistency_check;
	}
	public boolean isSnap_verify() {
		return snap_verify;
	}
	public void setSnap_verify(boolean snap_verify) {
		this.snap_verify = snap_verify;
	}
	public long getUntil_time() {
		return until_time;
	}
	public void setUntil_time(long until_time) {
		this.until_time = until_time;
	}
	
}
