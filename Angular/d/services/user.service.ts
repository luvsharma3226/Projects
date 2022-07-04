import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  userAPI = 'https://reqres.in/api/users/';
  constructor(private http: HttpClient, private httpModule: HttpClientModule) {}

  // getUsers(query: any) {
  //   console.log('getUsers() method from service called');
  //   // return this.http.post(this.userAPI + query, '');
  // }
}
