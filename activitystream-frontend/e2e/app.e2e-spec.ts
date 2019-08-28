import {browser, by, element } from 'protractor';
import { AppPage } from './app.po';
import {protractor } from 'protractor/built/ptor';

describe('activity-stream-frontend App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();    
  });

  it('should display title', () => {
    page.navigateTo();
    expect(browser.getTitle()).toEqual('Activity Stream');
  });

  it('should be redirected to /login route on opening the application', () => {
    expect(browser.getCurrentUrl()).toContain('/login');
  });

  it('should be redirected to /register route', () => {
    browser.element(by.id('nav-register-user')).click()
    expect(browser.getCurrentUrl()).toContain('/register')
  });

  it('should be able to register user', () => {
    browser.element(by.id('firstName')).sendKeys('f1');
    browser.element(by.id('lastName')).sendKeys('last1');
    browser.element(by.id('username')).sendKeys('user1');
    browser.element(by.id('password')).sendKeys('password');
    browser.driver.sleep(3000);
    browser.element(by.id('register-user')).click();
    browser.driver.sleep(5000);
    expect(browser.getCurrentUrl()).toContain('/login');
    browser.element(by.id('nav-register-user')).click()
    expect(browser.getCurrentUrl()).toContain('/register')
    browser.element(by.id('firstName')).sendKeys('f2');
    browser.element(by.id('lastName')).sendKeys('last2');
    browser.element(by.id('username')).sendKeys('user2');
    browser.element(by.id('password')).sendKeys('password');
    browser.driver.sleep(3000);
    browser.element(by.id('register-user')).click();
  });

  it('should be able to login user and navigate to messages', () => {
    browser.element(by.id('username')).sendKeys('user1');
    browser.element(by.id('password')).sendKeys('password');
    browser.element(by.id('login-user')).click()
    expect(browser.getCurrentUrl()).toContain('/message')
  });

  it('should be able to create circle', () => {
    browser.element(by.id('nav-create-circle')).click();
    expect(browser.getCurrentUrl()).toContain('/circle');
    browser.element(by.id('circleName')).sendKeys('test1')
    browser.element(by.id('create-circle')).sendKeys(protractor.Key.ENTER)
    browser.driver.sleep(1000);
    expect(browser.getCurrentUrl()).toContain('/message')
  });

  it('should be able to subscribe to circle', () => {
    browser.element(by.id('nav-create-circle')).click();

    expect(browser.getCurrentUrl()).toContain('/circle');
    browser.element(by.name('subscribeCircleName')).click();
    browser.element(by.cssContainingText('.mat-option','test1')).click();

   // browser.element(by.id('circleNameSubscribe')).sendKeys('test1')
    browser.element(by.id('create-user-circle')).sendKeys(protractor.Key.ENTER)
    browser.driver.sleep(1000);
    expect(browser.getCurrentUrl()).toContain('/message')
  });

  it('should be able to send message to circle', () => {
    browser.element(by.css('.circleName')).click();
    expect(browser.getCurrentUrl()).toContain('/message');
    browser.element(by.css('.messageInput')).sendKeys('sending message')
    browser.element(by.css('.messageButton')).sendKeys(protractor.Key.ENTER)
    browser.driver.sleep(1000);
    expect(browser.getCurrentUrl()).toContain('/message')
  });

  it('should be able to view message sent to circle ', async () =>{
    browser.driver.manage().window().maximize();
    browser.driver.sleep(1000);
    const searchItems = element.all(by.css('.messageData'));
    expect(searchItems.count()).toBe(1);
  });

  it('should be able to send message to user', () => {
    browser.element(by.css('.userItem')).click();
    expect(browser.getCurrentUrl()).toContain('/message');
    browser.element(by.css('.messageInput')).sendKeys('sending message to user')
    browser.element(by.css('.messageButton')).sendKeys(protractor.Key.ENTER)
    browser.driver.sleep(1000);
    expect(browser.getCurrentUrl()).toContain('/message')
  });

  it('should be able to view message sent to user ', async () =>{
    browser.element(by.css('.userItem')).click();
    browser.driver.manage().window().maximize();
    browser.driver.sleep(1000);
    const searchItems = element.all(by.css('.messageData'));
    expect(searchItems.count()).toBe(1);
  });

  it('should be logout', () => {
    browser.element(by.id('nav-logout-user')).click();
    expect(browser.getCurrentUrl()).toContain('/login');
  });
});
