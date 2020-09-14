import { Component, OnInit } from '@angular/core';
import { UserLoginService } from '../services/UserLogin/user-login.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;
  usernameCheck : number;

  constructor(private _userLoginService: UserLoginService, private http:HttpClient) { }

  ngOnInit(): void {
  }

  getLoginValue(username,password){

    this.username=username.value;
    this.password=password.value;

    console.log(this.username);
    console.log(username)

    this.http.get<number>('http://localhost:8080/supply_management/webapi/userlogin/checkUsername/'+this.username)
    .subscribe((data)=>{
      this.usernameCheck=data;
      console.log("data = "+ data)
    });

    console.log(this.usernameCheck);

  }



}
