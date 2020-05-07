import React, { Component } from 'react';
import './App.css';
import { Grid, Row, Col, Jumbotron } from 'react-bootstrap';
import RetailerClient from './Retailer';
import SuppliersClient from './Suppliers';

class App extends Component {

  constructor(props){
    super(props);
    this.state = {}
  }

  render() {
    return (
      <div className="App">
        <Jumbotron>
          <h1>Decentralized Supply Chain Management</h1>
        </Jumbotron>
        { }
        <Grid>
            <Row className="show-grid">
                <Col xs={12} md={6}>
                  <RetailerClient />
                </Col>
                <Col xs={12} md={6}>
                  <SuppliersClient />
                </Col>
            </Row>
        </Grid>
      </div>
    );
  }
}

export default App;
