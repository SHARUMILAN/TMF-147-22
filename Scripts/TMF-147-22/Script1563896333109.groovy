import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

WebUI.openBrowser('', FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://qatrunkapps.sqlpower.ca/')

WebUI.setText(findTestObject('Page_Login - Liferay/input_Email Address__58_login'), '2538244_cimatest_isd_2@org.com')

WebUI.setEncryptedText(findTestObject('Page_Login - Liferay/input_Password__58_password'), 'P9ET2sDE0SE=')

WebUI.click(findTestObject('Page_Login - Liferay/button_Sign In'))

WebUI.click(findTestObject('Page_Home - Liferay/span_Filings'))

WebUI.click(findTestObject('Page_Filings - Liferay/button2'))

WebUI.setText(findTestObject('Page_Filings - Liferay/button2'), 'INB-009-56')

WebUI.click(findTestObject('Page_Filings - Liferay/button3'))

WebUI.delay(10)

WebUI.click(findTestObject('Page_Filings - Liferay/button4'))

not_run: WebUI.switchToWindowTitle('')

WebUI.delay(4)

WebUI.switchToWindowTitle('Table of Schedules')

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Page_Filings - Liferay/button5'))

WebUI.waitForPageLoad(5)

WebUI.delay(8)

WebUI.click(findTestObject('Page_Filing Information/Name of person authorising returns'))

WebUI.setText(findTestObject('Page_Filing Information/Name of person authorising returns'), 'Hello')

WebUI.click(findTestObject('Page_Filing Information/Position'))

WebUI.setText(findTestObject('Page_Filing Information/Position'), 'Hi')

WebUI.selectOptionByValue(findTestObject('Page_Filing Information/Type of Business'), 'Long-Term Business', true)

WebUI.click(findTestObject('Page_Filing Information/a_Balance Sheet'))

not_run: WebUI.click(findTestObject('Page_Balance Sheet/Cash and cash equivalents'))

not_run: WebUI.setText(findTestObject('Page_Balance Sheet/Cash and cash equivalents'), '1')

not_run: WebUI.click(findTestObject('Page_Balance Sheet/Cash and Cash Equi 2'))

TestObject fillForm = new TestObject('fillForm')

String xPath

WebUI.click(findTestObject('Page_Balance Sheet/Cash and cash equivalents'))

for (int row = 1; row <= 64; row++) {
    for (int col = 1; col <= 2; col++) {
        xPath = (((('(.//*[normalize-space(text()) and normalize-space(.)=\'' + row) + '.0\'])/following::input[') + col) + 
        ']')

        fillForm.addProperty('xpath', ConditionType.EQUALS, xPath)

        WebUI.setText(fillForm, '12345')
    }
}

TestObject fillForm2 = new TestObject('fillForm2')

WebUI.click(findTestObject('Page_Filings - Liferay/button6'))

WebUI.click(findTestObject('Page_Balance Sheet/Cash and Cash Equi 2'))

//WebUI.click(findTestObject('Page_Balance Sheet/Cash and cash equivalents'))
for (int row = 66; row <= 96; row++) {
    for (int col = 1; col <= 2; col++) {
        xPath = (((('(.//*[normalize-space(text()) and normalize-space(.)=\'' + row) + '.0\'])/following::input[') + col) + 
        ']')

        fillForm2.addProperty('xpath', ConditionType.EQUALS, xPath)

        WebUI.setText(fillForm2, '12345')
    }
}

WebUI.click(findTestObject('Page_Filings - Liferay/button7'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_Balance Sheet/Investment Details'))

for (int row = 1; row <= 4; row++) {
    for (int col = 1; col <= 4; col++) {
        xPath = (((('(.//*[normalize-space(text()) and normalize-space(.)=\'' + row) + '\'])/following::input[') + col) + 
        ']')

        fillForm.addProperty('xpath', ConditionType.EQUALS, xPath)

        WebUI.setText(fillForm, '12345')
    }
}

WebUI.click(findTestObject('Page_Filings - Liferay/button8'))

WebUI.click(findTestObject('Page_Filings - Liferay/button9'))

WebUI.click(findTestObject('Page_Filings - Liferay/button10'))

WebUI.click(findTestObject('Page_Filings - Liferay/button11'))

WebUI.click(findTestObject('Page_Balance Sheet/Name of Actuarial company'))

WebUI.setText(findTestObject('Page_Balance Sheet/Name of Actuarial company'), 'Hi')

WebUI.click(findTestObject('Page_Filings - Liferay/button12'))

WebUI.click(findTestObject('Page_Balance Sheet/A'))

WebUI.setText(findTestObject('Page_Balance Sheet/A'), '212312321')

WebUI.click(findTestObject('Page_Balance Sheet/B'))

WebUI.setText(findTestObject('Page_Balance Sheet/B'), '2')

WebUI.click(findTestObject('Page_Balance Sheet/C'))

for (int row = 1; row <= 3; row++) {
    for (int col = 1; col <= 2; col++) {
        xPath = (((('(.//*[normalize-space(text()) and normalize-space(.)=\'' + row) + '\'])/following::input[') + col) + 
        ']')

        fillForm.addProperty('xpath', ConditionType.EQUALS, xPath)

        WebUI.setText(fillForm, '5555')
    }
}

WebUI.selectOptionByValue(findTestObject('Page_Filings - Liferay/button14'), 'AMBest:AA+', true)

WebUI.selectOptionByValue(findTestObject('Page_Filings - Liferay/button15'), 'Moody:Aa3', true)

WebUI.selectOptionByValue(findTestObject('Page_Filings - Liferay/button16'), 'S&P:BBB-', true)

WebUI.click(findTestObject('Page_Balance Sheet/C'))

for (int row = 1; row <= 2; row++) {
    for (int col = 1; col <= 5; col++) {
        xPath = (((('(.//*[normalize-space(text()) and normalize-space(.)=\'' + row) + '\'])/following::input[') + col) + 
        ']')

        fillForm.addProperty('xpath', ConditionType.EQUALS, xPath)

        WebUI.setText(fillForm, '1111111')
    }
}

WebUI.selectOptionByValue(findTestObject('Page_Filings - Liferay/button17'), 'Accident & Health', true)

WebUI.selectOptionByValue(findTestObject('Page_Filings - Liferay/button18'), 'HPL and Physicians Liability', true)

WebUI.click(findTestObject('Page_Balance Sheet/C - Copy'))

WebUI.setText(findTestObject('Page_Balance Sheet/C - Copy'), '1')

WebUI.click(findTestObject('Page_Filings - Liferay/button19'))

WebUI.setText(findTestObject('Page_Filings - Liferay/button19'), '2')

WebUI.click(findTestObject('Page_Filings - Liferay/button20'))

WebUI.setText(findTestObject('Page_Filings - Liferay/button20'), '3')

WebUI.delay(3)

WebUI.click(findTestObject('Page_Filings - Liferay/button21'))

WebUI.setText(findTestObject('Page_Filings - Liferay/button21'), '4')

WebUI.click(findTestObject('Page_Filings - Liferay/button22'))

WebUI.setText(findTestObject('Page_Filings - Liferay/button22'), '5')

WebUI.click(findTestObject('Page_Filings - Liferay/button23'))

WebUI.setText(findTestObject('Page_Filings - Liferay/button23'), '6')

not_run: WebUI.click(findTestObject('Page_Filings - Liferay/button24'))

not_run: WebUI.setText(findTestObject('Page_Filings - Liferay/button24'), '7')

WebUI.click(findTestObject('Page_Filings - Liferay/button25'))

not_run: WebUI.setText(findTestObject('Page_Filings - Liferay/button25'), '8')

not_run: WebUI.click(findTestObject('Page_Filings - Liferay/button26'))

not_run: WebUI.setText(findTestObject('Page_Filings - Liferay/button26'), '9')

not_run: WebUI.click(findTestObject('Page_Filings - Liferay/button27'))

not_run: WebUI.setText(findTestObject('Page_Filings - Liferay/button27'), '10')

not_run: WebUI.click(findTestObject('Page_Filings - Liferay/button28'))

not_run: WebUI.setText(findTestObject('Page_Filings - Liferay/button28'), '11')

not_run: WebUI.setText(findTestObject('Page_Balance Sheet/C'), '12122121')

not_run: WebUI.click(findTestObject('Page_Balance Sheet/D'))

not_run: WebUI.setText(findTestObject('Page_Balance Sheet/D'), '33')

not_run: WebUI.click(findTestObject('Page_Filings - Liferay/button13'))

not_run: WebUI.switchToWindowTitle('Table of Schedules')

not_run: WebUI.click(findTestObject('Page_Login - Liferay/button2'))

not_run: WebUI.selectOptionByValue(findTestObject('Page_Login - Liferay/button3'), 'Official liquidation', true)

not_run: WebUI.delay(2)

not_run: WebUI.click(findTestObject('Page_Login - Liferay/button7'))

not_run: WebUI.delay(2)

not_run: WebUI.click(findTestObject('Page_Login - Liferay/Upload File'))

not_run: WebUI.delay(2)

not_run: WebUI.click(findTestObject(null))

WebUI.click(findTestObject('Page_Filings - Liferay/button32'))

WebUI.click(findTestObject('Page_Filings - Liferay/button33'))

WebUI.click(findTestObject('Page_Filings - Liferay/button34'))

not_run: WebUI.click(findTestObject('Page_Filings - Liferay/button27'))

WebUI.uploadFile(findTestObject('Page_Filings - Liferay/button27'), RunConfiguration.getProjectDir() + '/Test-File/main (1).pdf')

not_run: WebUI.delay(2)

WebUI.uploadFile(findTestObject('Page_Filings - Liferay/button28'), RunConfiguration.getProjectDir() + '/Test-File/main (2).pdf')

WebUI.uploadFile(findTestObject('Page_Filings - Liferay/button29'), RunConfiguration.getProjectDir() + '/Test-File/main (3).pdf')

WebUI.uploadFile(findTestObject('Page_Filings - Liferay/button30'), RunConfiguration.getProjectDir() + '/Test-File/main.pdf')

not_run: WebUI.uploadFile(findTestObject('Page_Filings - Liferay/button31'), RunConfiguration.getProjectDir() + '/Test-File/main5.c')

not_run: WebUI.uploadFile(findTestObject('Page_Login - Liferay/Upload File'), '')

not_run: WebUI.setText(findTestObject('Object Repository/Page_Corporate Strategy/textarea'), 'Our mission is to empower every person and every organization on the planet to achieve more." ... Microsoft\'s mission statement expresses their belief in what people make possible. These beliefs and values are translated directly into their products and corporate culture.')

not_run: WebUI.click(findTestObject(null))

not_run: FilePath = WebUI.getAttribute(findTestObject('Upload File'), 'value')

not_run: WebUI.verifyMatch(FilePath, 'C:\\fakepath\\Desert.jpg', false)

WebUI.click(findTestObject('Page_Login - Liferay/button8'))

