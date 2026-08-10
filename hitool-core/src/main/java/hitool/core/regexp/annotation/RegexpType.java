package hitool.core.regexp.annotation;

/**
 * Enumeration defining RegexpType constants.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
public enum RegexpType {

	DATE{
		public String toString() {
			return "date";
		}
	},
	HTML{
		public String toString() {
			return "html";
		}
	},
	MATH{
		public String toString() {
			return "math";
		}
	},
	MOBILE{
		public String toString() {
			return "mobile";
		}
	},
	NET{
		public String toString() {
			return "net";
		}
	},
	SQL{
		public String toString() {
			return "sql";
		}
	},
	NORMAL{
		public String toString() {
			return "normal";
		}
	},
	SPECIAL{
		public String toString() {
			return "special";
		}
	}	
}
 