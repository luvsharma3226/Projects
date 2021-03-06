import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private httpClient: HttpClient) {}

  getUser(selectedId: number) {
    return this.httpClient.get('https://reqres.in/api/users/' + selectedId);
  }
}
