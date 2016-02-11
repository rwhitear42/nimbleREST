package com.rwhitear.nimbleRest.volumes.json;

public class OfflineVolumeDataObject {

		private boolean online;
		private boolean force;
		
		public OfflineVolumeDataObject() {
			
		}
		
		public boolean isOnline() {
			return online;
		}
		
		public void setOnline(boolean online) {
			this.online = online;
		}
		
		public boolean isForce() {
			return force;
		}
		
		public void setForce(boolean force) {
			this.force = force;
		}
		
}
