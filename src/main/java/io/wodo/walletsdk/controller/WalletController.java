package io.wodo.walletsdk.controller;

import io.wodo.walletsdk.domain.Wallet;
import io.wodo.walletsdk.model.request.WalletCreateRequest;
import io.wodo.walletsdk.model.request.WalletUpdateRequest;
import io.wodo.walletsdk.service.WalletService;
import io.wodo.walletsdk.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<Wallet> create(@RequestBody @Valid WalletCreateRequest createWalletRequest) {
        return ok(walletService.createWallet(createWalletRequest));
    }

    @GetMapping
    public ResponseEntity<Page<Wallet>> getAllWallets(@RequestParam(required = false) Integer size,
                                                      @RequestParam(required = false) Integer page) {

        Pageable pageable = Utils.createPageableBySizeAndPage(page, size);
        return ok(walletService.getAllWallets(pageable));
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<Wallet> getWalletById(@PathVariable Long walletId) {
        Wallet wallet = walletService.findById(walletId);
        return ok(wallet);
    }

    @PutMapping("/{walletId}")
    public ResponseEntity<Wallet> updateWalletById(@PathVariable Long walletId, @RequestBody @Valid WalletUpdateRequest walletUpdateRequest) {
        return ok(walletService.updateWallet(walletId, walletUpdateRequest));
    }

    @DeleteMapping("/{walletId}")
    public ResponseEntity<Wallet> deleteWalletById(@PathVariable Long walletId) {
        return ok(walletService.deleteWallet(walletId));
    }
}