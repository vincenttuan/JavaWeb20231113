package security.sign;
/*
 * 情境說明：
 * 小王是一家公司的經理，為了提高工作效率和保證文件的安全性，他決定使用數位簽章技術對公司的合同進行簽署。
 * 數位簽章不僅可以確保文件的完整性（即文件在傳輸過程中沒有被修改），還可以確認文件是由特定的人簽署的，
 * 在這種情況下，即由小王簽署。
 *
 * 本程式「DigitalSignatureCreator」的目的是生成一個數位簽章，該簽章對「my_contract.txt」文件進行簽署。
 * 這個數位簽章可以被存儲（在signature.sig文件中）和分享，供其他人或系統進行驗證。
 *
 * 當其他接收者接收到這個簽署的文件和數位簽章時，他們可以使用小王的公鑰來驗證文件的完整性和簽署者的身份。
 */
public class DigitalSignatureCreator {
	public static void main(String[] args) {
		// 小李
		// 小王合約檔位置
		String contractPath = "src/security/sign/my_contract.txt";
		// 小王公鑰檔位置
		String privateKeyPath = "src/security/sign/privateKey.key";
		// 小王數位簽章檔位置
		String signaturePath = "src/security/sign/signature.sig";	
	}
}
