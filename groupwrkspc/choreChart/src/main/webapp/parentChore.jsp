<html>
<body>
<h2>Parent Chore Page</h2>
<form action="index.jsp">
  Name of the chore:<br>
  <input type="text" name="chore"><br><br>
  
  Money earned upon completion:<br>
  <input type="text" name="amount"><br><br>
  
  Time allowed to complete chore:<br>
  <input type="text" name="time"><br>
  
  <select name="timeUnit">
    <option value="hours">Hours</option>
    <option value="days">Days</option>
    <option value="weeks">Weeks</option>
  </select>
  
  <br><br>Day of the week for chore:
  <select name="day">
    <option value="mon">Monday</option>
    <option value="tue">Tuesday</option>
    <option value="wed">Wednesday</option>
    <option value="thu">Thursday</option>
    <option value="fri">Friday</option>
    <option value="sat">Saturday</option>
    <option value="sun">Sunday</option>
  </select>
  
  <br><br>Repeat chore?<br>
  <input type="radio" name="repeat" value="true"> Yes<br>
  <input type="radio" name="repeat" value="false"> No<br>
 
 
</form>
</body>
</html>
