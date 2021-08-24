<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title> ȸ������ ������ </title>
    <link href="../css/MemberJoin3.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="body-wrap">
        <div class="member-wrap">
            <h1 class="gohome">
                <a href="#" title="���� �������� �̵�"><img src="../img/megaboxlogo.png">MEGABOX : Life Theater</a> 
            </h1>
            <div class="col-wrap">
                <div class="step-member">
                    <ol>
                        <li>
                            <p class="step">STEP1.��������</p>
                        </li>
                        <li>
                            <p class="step">STEP2.�������</p>
                        </li>
                        <li>
                            <p class="step on">STEP3.�����Է�</p>
                        </li>
                        <li>
                            <p class="step">STEP4.���ԿϷ�</p>
                        </li>
                    </ol>
                </div>
                <p class="page-info-txt">
                    <h3>*�� �ȳ��ϼ���.</h3>
                    <font size=2px color=gray>ȸ�������� �Է����ּ���</font>
                </p>
        
        
        <form method="post" action=C06MemberProc.jsp>  	
            <div class="table-wrap">
                <colgroup>
                    <col style="width:130px;">
                    <col>
                </colgroup>
                <table class="board-form">
                    <tbody>
                        <tr>
                            <th class="c1">�������</th>
                            <td>
	                            <select name=year id=year class="input-text day1" >
	                            	<option value="">��</option>
	                            	
	                            	<%
	                            		for(int i=2021;i>=1900;i--){
	                            			%>
	                            			<option value="<%=i %>">
	                            			<%=i %>
	                            			</option>
	                            			<%
	                            		}
	                            	%>
	                            	
	                            </select>
                            </td>
                            <td>
	                            <select name=month id=month class="input-text day2" >
	                            	<option value="">��</option>
	                            	
	                            	<%
	                            		for(int i=1;i<13;i++){
	                            			%>
	                            			<option value="<%=i %>">
	                            			<%=i %>
	                            			</option>
	                            			<%
	                            		}
	                            	%>
	                            	
	                            </select>
                            </td>
                            <td>
	                            <select name=day id=day class="input-text day3" >
	                            	<option value="">��</option>
	                            	
	                            	<%
	                            		for(int i=1;i<32;i++){
	                            			%>
	                            			<option value="<%=i %>">
	                            			<%=i %>
	                            			</option>
	                            			<%
	                            		}
	                            	%>
	                            	
	                            </select>
                            </td>
                        </tr>
                        <tr>
                            <th class="c1">�޴��� ��ȣ</th>
                            <td>
                            <input type="tel" size=5px name="ph1" placeholder="01*" pattern=[0-1]{3} class="input-text ph1" required> 
                            - 
                            <input type="tel" size=5px name="ph2" placeholder="****" pattern=[0-9]{3,4} class="input-text ph2" required> 
                            - 
                            <input type="tel" size=5px name="ph3" placeholder="****" pattern=[0-9]{4} class="input-text ph3" required></td>
                        </tr>
                        <tr>
                            <th class="c1">���̵�</th>
                            <td><input type="text" id="id" name="userid" placeholder="����, ���� ����(8~12��)" class="input-text" required>
                                <a href="#"><input type=button value=�ߺ�Ȯ�� class="button idoverlap"></a></td>
                        </tr>
                        <tr>
                            <th class="c1">��й�ȣ</th>
                            <td><input type="password" id="pwd" name="pwd" placeholder="����, ����, Ư����ȣ �� 2���� �̻� ����" class="input-text" required></td>
                        </tr>
                        <tr>
                            <th class="c1">��й�ȣȮ��</th>
                            <td><input type="password" id="pwcheck" name="pwcheck" placeholder="����, ����, Ư����ȣ �� 2���� �̻� ����" class="input-text" required></td>
                        </tr>
                        <tr>
                            <th class="c1">�̸���</th>
                            <td><input type="email" name=email placeholder="�̸����ּҸ� �Է��� �ּ���" class="input-text" required></td>
                        </tr>
                        <tr>
                            <th class="c1">���ι߱Ǳ�<br>��� ����</th>
                            <td class="tick_td">
                            <input type="radio" id="ticketY" name="ticketSet">
                            <label for="ticketY">"���"</label>
                            <input type="radio" id="ticketN" name="ticketSet">
                            <label for="ticketN">"������"</label>
                            </td>
                            <td class="outprint">
                            	<p class="outprint p">�� '������� + �޴�����ȣ��' Ƽ�� ���</p>
                            </td>
                        </tr>
                        <tr>
                            <th class="c1">������ �ް��ڽ�</th>
                            <td style="word-wrap:break-word;">
                            <span>���� �湮�ϴ� �ް��ڽ��� ����� �ּ���!</span>
                            <a href="#"><input type="button" value="����" class="button setmegabox"></a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        <div class="marketing-agree">
            <p class="phr">������ Ȱ���� ���� �������� ���� �̿� �ȳ�(����)</p>
            <div class="cont">
                <dl>
                    <dt>��������</dt>
                    <dd>�������� ��ǰ �� ���� ��õ, ��� �ű� ��ǰ/���� �ȳ� �� ����,<br>
                        ����/���� ��� �� ���� �̺�Ʈ ���� ���� �ȳ� �� ����</dd>
                    <dt>�����׸�</dt>
                    <dd>�̸���, �޴�����ȣ, �ּ�, �������, ��ȣ��ȭ��, ����/�̸���/��Ǫ��<br>
                        �������ŵ��� ����, ���� �̿���, ����Ʈ ���� �� ��� ����, ���� �α�</dd>
                    <dt>�����Ⱓ</dt>
                    <dd>ȸ�� Ż�� �� Ȥ�� �̿� ���� �޼� �� ����</dd>
                </dl>
                <div class="markag radagree">
                    <input type="radio" id="agree" name="agreeSet">
                    <label for="agreeY">"����"</label>
                    <input type="radio" id="disagree" name="agreeSet">
                    <label for="disagree">"�̵���"</label>
                </div>
                <p class="samedt">���� ���ż���</p>
                <div class="markag chebox">
                    <input type="checkbox" id="push">
                    <label for="push">�˸�</label>
                    <input type="checkbox" id="SMS">
                    <label for="SMS">SMS</label>
                    <input type="checkbox" id="email">
                    <label for="email">�̸���</label>
                </div>
                <p class="samedd">
                    �� �̺�Ʈ, �ű� ����, ���� ���� ���� �ҽ��� ���� �帳�ϴ�.<br>
                    (�Ҹ�����Ʈ �� ������ �ȳ� �Ǵ� �ŷ������� ���õ� ������<br> ���� ���� ���ο� ������� �߼۵˴ϴ�.)
                </p>
            </div>
        </div>
        <br>
        <div class="footer">
        <button type="button" class="button join" onclick="joinForm_check();">ȸ������</button>
        </div>
        
        </form>
        
        
        </div>
        </div>
        </div>
</body>
</html>