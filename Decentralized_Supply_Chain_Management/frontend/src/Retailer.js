
import React, { Component } from 'react';
import { supplierContract, retailerContract, web3 } from "./WebSet3";
import { Grid, Row, Col, Panel, Tabs, Tab, Table } from 'react-bootstrap';
import './App.css';

class RetailerClient extends Component {

    constructor(props) {
        super(props);
        this.state = {
            supplierContract_blockchainRecordedItemIds: [],
            retailerContract_blockchainRecordedPurchaseOrderIds: []
        };

        /* event listeners */
        this.supplierContract_itemAddedEvents = supplierContract.ItemAdded({}, {
            fromBlock: 0,
            toBlock: 'latest'
        });

        this.supplierContract_processAnOrderEvents = supplierContract.ProcessAnOrder({}, {
            fromBlock: 0,
            toBlock: 'latest'
        });

        this.retailerContract_OrderRaisedOrUpdatedEvents = retailerContract.OrderRaisedOrUpdated({}, {
            fromBlock: 0,
            toBlock: 'latest'
        });

        /* Getters */
        this.supplierContract_getItem = this.supplierContract_getItem.bind(this);
        this.supplierContract_getStatus = this.supplierContract_getStatus.bind(this);
        this.retailerContract_getOrderDetails = this.retailerContract_getOrderDetails.bind(this);
        this.retailerContract_getNumberOfItemsPurchased = this.retailerContract_getNumberOfItemsPurchased.bind(this);
        this.retailerContract_getNumberOfItemsReceived = this.retailerContract_getNumberOfItemsReceived.bind(this);

        /* transactions */
        this.retailerContract_purchaseItem = this.retailerContract_purchaseItem.bind(this);
        this.retailerContract_recieveItem = this.retailerContract_recieveItem.bind(this);

        this.triggerretailerContractEventListeners = this.triggerretailerContractEventListeners.bind(this);
        this.purchaseThisItem = this.purchaseThisItem.bind(this);
    }

    componentDidMount(){
        this.triggerretailerContractEventListeners();
    }

    triggerretailerContractEventListeners() {

        this.supplierContract_itemAddedEvents.watch((err, eventLogs) => {
            if (err) {
                console.error('[Event Listener Error]', err);
            } else {
                console.log('[Event Logs]', eventLogs);
                this.setState({
                    supplierContract_blockchainRecordedItemIds: [...this.state.supplierContract_blockchainRecordedItemIds,
                        parseInt(eventLogs.args.idItem.toString())
                    ]
                });
            }
        });

        this.retailerContract_OrderRaisedOrUpdatedEvents.watch((err, eventLogs) => {
            if (err) {
                console.error('[Event Listener Error]', err);
            } else {
                console.log('[Event Logs]', eventLogs);
                this.setState({
                    retailerContract_blockchainRecordedPurchaseOrderIds: [...this.state.retailerContract_blockchainRecordedPurchaseOrderIds,
                        parseInt(eventLogs.args.idOrder.toString())
                    ]
                });
            }
        });

        this.supplierContract_processAnOrderEvents.watch((err, eventLogs) => {
            if (err) {
                console.error('[Event Listener Error]', err);
            } else {
                console.log('[Event Logs]', eventLogs);
                if (eventLogs.args.status){
                    this.retailerContract_recieveItem(parseInt(eventLogs.args.idOrder.toString()));
                }
            }
        });
    }

    supplierContract_getItem(idItem) {
        return supplierContract.getItem.call(idItem);
    }
    supplierContract_getStatus(idOrder) {
        return supplierContract.getStatus.call(idOrder);
    }

    retailerContract_getOrderDetails(idOrder) {
        return retailerContract.getOrderDetails.call(idOrder);
    }
    retailerContract_getNumberOfItemsPurchased() {
        return retailerContract.getNumberOfItemsPurchased.call();
    }
    retailerContract_getNumberOfItemsReceived() {
        return retailerContract.getNumberOfItemsReceived.call();
    }

    retailerContract_purchaseItem(itemName, quantity) {
        retailerContract.purchaseItem(itemName, quantity, {
            from: web3.eth.accounts[0],
            gas: 200000
        }, (err, results) => {
            if (err) {
                console.error('[Retailer Contract] Error during purchasing an item', err);
            } else {
                console.log('[Retailer Contract] - item purchased', results.toString());
            }
        });
    }

    retailerContract_recieveItem(idOrder) {
        retailerContract.recieveItem(idOrder, {
            from: web3.eth.accounts[0],
            gas: 200000
        }, (err, results) => {
            if (err) {
                console.error('[Retailer Contract] Error during obtaining ordered item', err);
            } else {
                console.log('[Retailer Contract] - item received successfully!', results.toString());
            }
        });
    }

    purchaseThisItem(itemDetails)
    {
        this.retailerContract_purchaseItem(itemDetails.itemName, itemDetails.quantity);
    }


    render(){
        return (
            <div>
                <Grid>
                    <Row className="show-grid">
                        <Col xs={12} md={6}>
                            <Panel>
                                <Panel.Heading>Retailer Section</Panel.Heading>
                                <Panel.Body>
                                    <Tabs defaultActiveKey={1} id="uncontrolled-tab-example">
                                        <Tab eventKey={1} title="Market">
                                            {this.state.supplierContract_blockchainRecordedItemIds.map(itemId => {
                                                let itemDetails = this.supplierContract_getItem(itemId);
                                                return (
                                                    <div>
                                                        <Panel onClick={() => this.purchaseThisItem({
                                                            'id': itemId,
                                                            'itemName': web3.toUtf8(String(itemDetails).split(',')[0]),
                                                            'price': parseInt(String(itemDetails).split(',')[1]),
                                                            'quantity': 1
                                                        })}>
                                                            <Panel.Heading className="pointIt"><small>Click to purchase</small></Panel.Heading>
                                                            <Panel.Body>
                                                                {web3.toUtf8(String(itemDetails).split(',')[0])} --> {parseInt(String(itemDetails).split(',')[1])}€
                                                            </Panel.Body>
                                                        </Panel>
                                                    </div>
                                                );
                                            })}
                                        </Tab>
                                        <Tab eventKey={2} title="Order">
                                            <h4>Order details</h4>
                                            <Table striped bordered condensed hover>
                                                <thead>
                                                    <tr>
                                                    <th>Order ID</th>
                                                    <th>Item Name</th>
                                                    <th>Quantity</th>
                                                    <th>Order Completed</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    {
                                                    [... new Set(this.state.retailerContract_blockchainRecordedPurchaseOrderIds)].map(orderId => {
                                                        const orderDetails = this.retailerContract_getOrderDetails(orderId);

                                                        return (<tr>
                                                            <td>
                                                            {orderId}
                                                            </td>
                                                            <td>
                                                            {web3.toUtf8(String(orderDetails).split(',')[0])}
                                                            </td>
                                                            <td>
                                                            {parseInt(String(orderDetails).split(',')[1])}
                                                            </td>
                                                            <td>
                                                            {String(orderDetails).split(',')[2]}
                                                            </td>
                                                        </tr>);
                                                    }
                                                )}
                                                </tbody>
                                            </Table>
                                        </Tab>
                                    </Tabs>
                                </Panel.Body>
                            </Panel>
                        </Col>
                    </Row>
                </Grid>
            </div>
        );
    }

}

export default RetailerClient;