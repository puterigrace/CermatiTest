Feature: Automation for cermati testing

Scenario: Sign Up to Cermati
	Given user enter the sign up site
	When user input email
	And user input kata sandi
	And user input konfirmasi kata sandi
	And user input nama anda
	And user input nama belakang
	And user input nomor telepon
	And user choose kabupaten kota
	And click daftar akun button
	Then user successfully registered