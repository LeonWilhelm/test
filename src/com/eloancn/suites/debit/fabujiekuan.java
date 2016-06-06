package com.eloancn.suites.debit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.eloancn.shared.common.Base;
import com.eloancn.shared.common.DBData;
import com.eloancn.shared.common.Data;
import com.eloancn.shared.pages.ClientBackPage;
import com.eloancn.shared.pages.InvestmentDetailPage;
import com.eloancn.shared.pages.InvestmentListPage;
import com.eloancn.shared.pages.LoanApplicationPage;
import com.eloancn.shared.pages.LoginPage;
import com.eloancn.shared.pages.MyAccountPage;
import com.eloancn.shared.pages.MyLoanPage;

public class fabujiekuan {
	Base base = new Base();
	DBData dbdata = new DBData();
	MyAccountPage myAccountPage = new MyAccountPage();
	LoginPage loginpage = new LoginPage();
	LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
	MyLoanPage myloanpage = new MyLoanPage();
	InvestmentListPage investlistpage = new InvestmentListPage();
	InvestmentDetailPage investdetailpage = new InvestmentDetailPage();
	ClientBackPage backpage = new ClientBackPage();
	int ownerid=698116;

	@Test (priority = 1)
	//申请借款并且总部初审通过
	public void PassFirstAudit(){
		if(base.indexURL.contains("client")){
			int ownerids[]={703654,
					703652,
					703645,
					703644,
					703637,
					703634,
					703632,
					703631,
					703630,
					703629,
					703624,
					703620,
					703613,
					703551,
					703055,
					703021,
					702928,
					702672,
					702492,
					701695,
					701652,
					701645,
					701644,
					701633,
					701588,
					701442,
					701304,
					701241,
					701189,
					701180,
					701179,
					701148,
					701141,
					701138,
					700793,
					700550,
					700548,
					700493,
					700492,
					700466,
					700460,
					700319,
					700277,
					700192,
					700137,
					700112,
					699343,
					698638,
					479381,
					10850
};
			int serialnumber=1449959839;
			for(int i=0;i<ownerids.length;i++){
				loanApplicationPage.ApplyLoan(serialnumber,ownerids[i]);
				serialnumber++;
			}
		}
	}
}
